/*
package miit.uvp.free.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/students")
    Iterable<StudentDTO> all(){return studentService.getAll();}

    @PostMapping("/studentNew")
    StudentDTO newStudent(@RequestBody StudentDTO newStudent){return studentService.register(newStudent);}

    @GetMapping("/student/{id}")
    StudentDTO one(@PathVariable Long id) {return (StudentDTO) studentService.findStudent(id);}

    @DeleteMapping("/studentDelete/{id}")
    void deleteStudent(@PathVariable Long id){studentService.expel(id);}

}
*/
