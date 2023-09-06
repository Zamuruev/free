
package miit.uvp.free.controllers;

import miit.uvp.free.Exception.StudentNotFoundException;
import miit.uvp.free.dtos.StudentDTO;
import miit.uvp.free.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/students")
    List all(){return studentService.getAll();}

    @PostMapping("/studentNew")
    StudentDTO newStudent(@RequestBody StudentDTO newStudent){return studentService.register(newStudent);}

    @GetMapping("/student/{id}")
    StudentDTO one(@PathVariable Long id) throws Throwable { return (StudentDTO) studentService.findStudent(id)
            .orElseThrow(() -> new StudentNotFoundException(id)); }

    @DeleteMapping("/studentDelete/{id}")
    void deleteStudent(@PathVariable Long id){studentService.expel(id);}

    @GetMapping("/allStudents/{schoolClassName}")
    List<StudentDTO> findStudentsBySchoolClassName(@PathVariable("schoolClassName") String schoolClassName) {
        return studentService.findStudentsBySchoolClassName(schoolClassName);
    }

}


