
package miit.uvp.free.controllers;

import miit.uvp.free.Exception.StudentNotFoundException;
import miit.uvp.free.Exception.TeacherNotFoundException;
import miit.uvp.free.Exception.TeacherNotFoundException2;
import miit.uvp.free.dtos.TeacherDTO;
import miit.uvp.free.models.Teacher;
import miit.uvp.free.repositories.TeacherRepository;
import miit.uvp.free.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @GetMapping("/teachers")
    Iterable<TeacherDTO> all(){return teacherService.getAll();}

    @GetMapping("/teacher/{id}")
    TeacherDTO one(@PathVariable Long id) throws Throwable{ return (TeacherDTO) teacherService.findTeacher(id)
            .orElseThrow(() -> new TeacherNotFoundException(id));}

    @DeleteMapping("/teacher_delete/{id}")
    void deleteTeacher(@PathVariable Long id){teacherService.expel(id);}

    @GetMapping("/teacher_schoolclassName/{schoolClassName}")
    List<Teacher> findAllTeachersBySchoolClassName(@PathVariable("schoolClassName") String schoolClassName) {
        return teacherService.findAllTeachersBySchoolClassname(schoolClassName);
    }

    @GetMapping("/teacher_schoolclassId/{schoolClassId}")
    List<Teacher> findAllTeachersBySchoolClassId(@PathVariable("schoolClassId")Long schoolClassId){return teacherService.findallTeachersBySchoolClassId(schoolClassId);}

    @GetMapping("/teacher_subjectId/{id}")
    List<Teacher> findAllBySubjectId(@PathVariable Long id){
        return teacherService.findallTeachersBySubjectId(id);
    }

    @GetMapping("/teacher_subjectName/{subjectName}")
    List<Teacher> findAllBySubjectName(@PathVariable("subjectName") String subjectName) {
        return teacherService.findallTeachersBySubjectName(subjectName);
    }
    @GetMapping("/teacher_position/{position}")
    TeacherDTO one(@PathVariable String position) throws Throwable { return (TeacherDTO) teacherService.findAllByPosition(position)
            .orElseThrow(() -> new TeacherNotFoundException2(position));}

}
