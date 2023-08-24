
package miit.uvp.free.services;

import miit.uvp.free.dtos.TeacherDTO;

import java.util.List;
import java.util.Optional;

public interface TeacherService<ID> {
    void expel(ID id);
    Optional<TeacherDTO> findTeacher(ID id);
    List<TeacherDTO> getAll();

    List<TeacherDTO> findAllByPosition(String position);
}

