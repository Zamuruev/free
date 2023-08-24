package miit.uvp.free.services;

import miit.uvp.free.dtos.SchoolClassDTO;
import miit.uvp.free.dtos.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService<ID> {
    StudentDTO register(StudentDTO student);
    void expel(StudentDTO student);
    void expel(ID id);
    void transfer(StudentDTO student, SchoolClassDTO schoolClass);
    Optional<StudentDTO> findStudent(ID id);
    List<StudentDTO> getAll();
    List<StudentDTO> findStudentsBySchoolClass(String schoolClassName);

}

