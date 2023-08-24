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

    @Query("SELECT t FROM Teacher t JOIN t.schoolClassTeachers sct JOIN sct.schoolClass sc WHERE sc.name = :schoolClassName")
    List<Teacher> findAllBySchoolClassName(@Param("schoolClassName") String schoolClassName);

    @Query("SELECT t FROM Teacher t JOIN t.schoolClassTeachers sct JOIN sct.schoolClass sc WHERE sc.id = :schoolClassId")
    List<Teacher> findAllBySchoolClassId(@Param("schoolClassId") Long schoolClassId);

    @Query("SELECT t FROM Teacher t JOIN t.teacherSubjects ts JOIN ts.subject s WHERE s.id = :subjectId")
    List<Teacher> findAllBySubjectId(@Param("subjectId") Long subjectId);

    @Query("SELECT t FROM Teacher t JOIN t.teacherSubjects ts JOIN ts.subject s WHERE s.name = :subjectName")
    List<Teacher> findAllBySubjectName(@Param("subjectName") String subjectName);

}

