package miit.uvp.free.services;

import java.util.List;
import java.util.Optional;

public interface TeacherService<ID> {
    void expel(ID id);
    Optional<TeacherDTO> findTeacher(ID id);
    List<TeacherDTO> getAll();
}
