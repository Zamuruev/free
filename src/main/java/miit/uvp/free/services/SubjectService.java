package miit.uvp.free.services;

import miit.uvp.free.dtos.SubjectDTO;

import java.util.List;
import java.util.Optional;

public interface SubjectService<ID> {
    SubjectDTO register(SubjectDTO subject);
    void expel(ID id);
    Optional<SubjectDTO> findSubject(ID id);
    List<SubjectDTO> getAll();

}
