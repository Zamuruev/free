
package miit.uvp.free.services;

import miit.uvp.free.dtos.TeacherDTO;

import java.util.List;
import java.util.Optional;

public interface TeacherService<ID> {
    TeacherDTO register(TeacherDTO teacher);
    void expel(ID id);
    void expel(TeacherDTO teacher);

    Optional<TeacherDTO> findTeacher(ID id);
    List<TeacherDTO> getAll();

    List<TeacherDTO> findTeachersBySchoolClassName(String name);

    List<TeacherDTO> findTeachersBySubjectName(String name);

}

