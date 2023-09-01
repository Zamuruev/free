package miit.uvp.free.repositories;

import miit.uvp.free.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    List<Teacher> findAllByPosition(String position);
    Optional<Teacher>findById(Long id);

    @Query("SELECT sct.id.teacher FROM SchoolClassTeacher sct WHERE sct.id.schoolClass.name = :schoolClassName")
    List<Teacher> findAllTeachersBySchoolClassName(@Param("schoolClassName") String schoolClassName);

    @Query("SELECT sct.id.teacher FROM SchoolClassTeacher sct WHERE sct.id.schoolClass.id = :schoolClassId")
    List<Teacher> findAllTeachersBySchoolClassId(@Param("schoolClassId") Long schoolClassId);

    @Query("SELECT t FROM Teacher t JOIN t.teacherSubjects ts JOIN ts.id.subject s WHERE s.id = :subjectId")
    List<Teacher> findAllBySubjectId(@Param("subjectId") Long subjectId);

    @Query("SELECT t FROM Teacher t JOIN t.teacherSubjects ts JOIN ts.id.subject s WHERE s.name = :subjectName")
    List<Teacher> findAllBySubjectName(@Param("subjectName") String subjectName);

}

