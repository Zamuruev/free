package miit.uvp.free.services;

import miit.uvp.free.dtos.SchoolClassDTO;
import miit.uvp.free.dtos.SubjectDTO;


import java.util.List;
import java.util.Optional;

public interface SubjectService<ID> {

    SubjectDTO register(SubjectDTO subjectDTO, List<SchoolClassDTO> schoolClasses);
    void expel(ID id);
    Optional<SubjectDTO> findSubject(ID id);
    List<SubjectDTO> getAll();

}
