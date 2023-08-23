package miit.uvp.free.controllers;

import miit.uvp.free.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teachers")
    Iterable<TeacherDTO> all(){return teacherService.getAll();}

    @GetMapping("/teacher/{id}")
    TeacherDTO one(@PathVariable Long id){return (TeacherDTO) teacherService.findTeacher(id);}

    @DeleteMapping("/teacher_delete/{id}")
    void deleteTeacher(@PathVariable Long id){teacherService.expel(id);}

}
