package com.olegmng.AppStudent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students", method = RequestMethod.GET)
public class StudentController {

    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping(value = "/info", produces = MediaType.TEXT_HTML_VALUE)
    public String getText() {
        return """
                <h3>README.md</h3>
                """;
    }

    @GetMapping("/all")
    public List<Student> getUsers() {
        return studentRepository.getAll();
    }

    @GetMapping("/{id}")
    public Student getUser(@PathVariable long id) {
        return studentRepository.getById(id);
    }

    //return the list of students of the same name
    @GetMapping
    public List<Student> getUser(@RequestParam String name) {
        return studentRepository.getByName(name);
    }

    @PutMapping("/students/{id}")
    public Student updateUser(@PathVariable long id, @RequestBody Student student) {
        Student existStudent = studentRepository.getById(id);
        if (existStudent == null) {
            throw new IllegalArgumentException();
        }

        existStudent.setName(student.getName());
        return existStudent;
    }

    //Post method to add new student
    @PostMapping("/add/{id}")
    public Student addUser(@PathVariable long id, @RequestBody Student student) {
        Student addStudent = new Student(student.getName(), student.getGroupName());
        studentRepository.addStudent(student);

        return studentRepository.getById(id);
    }

    //Post method to add new student
    @DeleteMapping("/delete/{id}")
    public List<Student> addUser(@PathVariable long id) {
        Student st = studentRepository.getById(id);
        List<Student> delStudentList = studentRepository.deleteStudent(st);

        return delStudentList;
    }

}
