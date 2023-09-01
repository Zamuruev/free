
package miit.uvp.free.services;

import miit.uvp.free.dtos.SchoolClassDTO;
import miit.uvp.free.dtos.TeacherDTO;

import java.util.List;
import java.util.Optional;

public interface TeacherService<ID> {
    TeacherDTO register(TeacherDTO teacherDTO, List<SchoolClassDTO> schoolClasses);
    void expel(ID id);
    void expel(TeacherDTO teacher);

    Optional<TeacherDTO> findTeacher(ID id);
    List<TeacherDTO> getAll();

    List<TeacherDTO> findTeachersBySchoolClassName(String name);

    List<TeacherDTO> findTeachersBySubjectName(String name);

}

