package com.olegmng.AppStudent;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

@Data

public class Student {
    private static long idLonger = 1L;

    private final long id;
    private String name;
    private String groupName;

    public Student(String name, String groupName) {
        this.id = idLonger++;
        this.name = name;
        this.groupName = groupName;
    }

    @JsonCreator
    public Student(long id, String name, String groupName) {
        this.id = id;
        this.name = name;
        this.groupName = groupName;
    }

}

