package miit.uvp.free.services;


import miit.uvp.free.dtos.SubjectDTO;
import miit.uvp.free.dtos.TeacherDTO;

public interface TeacherSubjectService<ID> {
    void merge(SubjectDTO subjectDTO, TeacherDTO teacherDTO);
}
