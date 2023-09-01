package miit.uvp.free.repositories;

import miit.uvp.free.models.TeacherSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherSubjectRepository extends JpaRepository<TeacherSubject, TeacherSubject.TeacherSubjectId> {
}
