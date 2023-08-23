package miit.uvp.free.services;

import java.util.Optional;

public interface SubjectService<ID> {
    void expel(ID id);
    Optional<SubjectDTO> findSubject(ID id);
    List<SubjectDTO> getAll();
}
