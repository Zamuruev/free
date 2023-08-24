
package miit.uvp.free.controllers;

import miit.uvp.free.dtos.SchoolClassDTO;
import miit.uvp.free.models.SchoolClass;
import miit.uvp.free.services.SchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class SchoolClassController {
    @Autowired
    private SchoolClassService schoolClassService;

    @GetMapping("/school_classes")
    Iterable<SchoolClassDTO> all(){return schoolClassService.getAll();}


    /*@GetMapping("/school_class/{id}")
    SchoolClassDTO one(@PathVariable Long id){return (SchoolClassDTO) schoolClassService.findSchoolClass(id);}*/

    @DeleteMapping("/school_class_delete/{id}")
    void deleteSchoolClass(@PathVariable Long id){schoolClassService.expel(id);}

    @PostMapping("/school_class/new")
    SchoolClassDTO newSchoolClass(@RequestBody SchoolClassDTO newSchoolClass){return schoolClassService.register(newSchoolClass);}
}

