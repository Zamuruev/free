package miit.uvp.free.repositories;

import miit.uvp.free.models.SchoolClass;
import miit.uvp.free.models.SchoolClassTeacher;
import miit.uvp.free.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolClassTeacherRepository extends JpaRepository<SchoolClassTeacher, SchoolClassTeacher.SchoolClassTeacherId> {
    /*void deleteById_TeacherAndId_SchoolClass(Teacher teacher, SchoolClass schoolClass);
    boolean existsById_TeacherIdAndId_SchoolClassId(Long teacherId, Long schoolClassId);
    List<SchoolClassTeacher> findById_Teacher(Teacher teacher);*/

}