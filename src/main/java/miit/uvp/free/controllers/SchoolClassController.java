
package miit.uvp.free.controllers;

import miit.uvp.free.Exception.SchoolClassNotFoundException;
import miit.uvp.free.Exception.SchoolClassNotFoundException2;
import miit.uvp.free.Exception.StudentNotFoundException;
import miit.uvp.free.Exception.TeacherNotFoundException2;
import miit.uvp.free.dtos.SchoolClassDTO;
import miit.uvp.free.models.SchoolClass;
import miit.uvp.free.services.SchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class SchoolClassController {
    @Autowired
    private SchoolClassService schoolClassService;

    @GetMapping("/school_classes")
    Iterable<SchoolClassDTO> all(){return schoolClassService.getAll();}

    @GetMapping("/school_class/{id}")
    SchoolClassDTO one(@PathVariable Long id) throws Throwable { return (SchoolClassDTO) schoolClassService.findSchoolClass(id)
            .orElseThrow(() -> new SchoolClassNotFoundException(id)); }


    @DeleteMapping("/school_class_delete/{id}")
    void deleteSchoolClass(@PathVariable Long id){schoolClassService.expel(id);}

    @PostMapping("/school_class/new")
    SchoolClassDTO newSchoolClass(@RequestBody SchoolClassDTO newSchoolClass){return schoolClassService.register(newSchoolClass);}

    @GetMapping("/school_class_studentId/{id}")
    SchoolClassDTO second(@PathVariable Long id) throws Throwable{ return (SchoolClassDTO) schoolClassService.findSchoolClassByStudentId(id)
            .orElseThrow(() -> new SchoolClassNotFoundException2(id));}

}

