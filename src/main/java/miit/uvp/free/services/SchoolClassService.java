package miit.uvp.free.services;

import miit.uvp.free.dtos.SchoolClassDTO;
import miit.uvp.free.dtos.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface SchoolClassService<ID> {
    Optional<SchoolClassDTO> findSchoolClass(ID id);
    List<SchoolClassDTO> getAll();
    List<SchoolClassDTO> findSchoolClassByStudent(String nameStudent);
    void expel(ID id);

    SchoolClassDTO register(SchoolClassDTO schoolClass);

}
