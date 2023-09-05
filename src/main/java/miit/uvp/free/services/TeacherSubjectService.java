package miit.uvp.free.services;


import miit.uvp.free.dtos.SubjectDTO;
import miit.uvp.free.dtos.TeacherDTO;
import org.springframework.transaction.annotation.Transactional;

public interface TeacherSubjectService<ID> {
    @Transactional
    void merge(SubjectDTO subjectDTO, TeacherDTO teacherDTO);
}
