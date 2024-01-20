package com.olegmng.AppStudent;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class StudentRepository {
    private List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
        students.add(new Student("Oleg", "1177"));
        students.add(new Student("Petr", "2211"));
        students.add(new Student("Klim", "1177"));
        students.add(new Student("Olga", "3387"));
        students.add(new Student("Olga", "4321"));
    }

    public List<Student> getAll() {
        return List.copyOf(students);

    }

    public List<Student> getByName(String name) {
        return students.stream().
                filter(it -> Objects.equals(it.getName(), name)).collect(Collectors.toList());
    }

    public Student getById(long id) {
        return students.stream().
                filter(it -> Objects.equals(it.getId(), id)).
                findFirst().
                orElse(null);
    }

    public List<Student> addStudent(Student student) {
        students.add(student);
        return List.copyOf(students);

    }

    public List<Student> deleteStudent(Student student) {
        this.students.remove(student);
        return List.copyOf(students);

    }
}
