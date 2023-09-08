
package miit.uvp.free.services;

import miit.uvp.free.dtos.SchoolClassDTO;
import miit.uvp.free.dtos.SubjectDTO;
import miit.uvp.free.dtos.TeacherDTO;
import miit.uvp.free.models.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService<ID> {
    TeacherDTO register(TeacherDTO teacherDTO, List<SchoolClassDTO> schoolClasses);
    void expel(ID id);

    Optional<TeacherDTO> findTeacher(ID id);
    List<TeacherDTO> getAll();

    Optional<TeacherDTO> findAllByPosition(String position);

    List<Teacher> findallTeachersBySchoolClassId(Long schoolClassId);

    List<Teacher> findallTeachersBySubjectId(Long subjectId);

    List<Teacher> findAllTeachersBySchoolClassname(String schoolclassName);

    List<Teacher> findallTeachersBySubjectName(String subjectName);

}

