
package miit.uvp.free.controllers;

import miit.uvp.free.Exception.StudentNotFoundException;
import miit.uvp.free.Exception.SubjectNotFoundException;
import miit.uvp.free.dtos.SubjectDTO;
import miit.uvp.free.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/subjects")
    Iterable<SubjectDTO> all(){return subjectService.getAll();}

    @GetMapping("/subject/{id}")
    SubjectDTO one(@PathVariable Long id) throws Throwable{return (SubjectDTO) subjectService.findSubject(id)
            .orElseThrow(() -> new SubjectNotFoundException(id));}

    @DeleteMapping("/subject_delete/{id}")
    void deleteSubject(@PathVariable Long id){subjectService.expel(id);}

}

