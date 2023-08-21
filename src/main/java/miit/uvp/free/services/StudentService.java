package miit.uvp.free.services;

import miit.uvp.free.dtos.StudentDTO;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

public interface StudentService<ID> {


    Optional<StudentDTO> findStudent(ID id);
    List<StudentDTO> getAll();
    List<StudentDTO> findStudentsBySchoolClass(String schoolClass);

}
