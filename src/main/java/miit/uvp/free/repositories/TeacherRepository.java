
package miit.uvp.free.repositories;

import miit.uvp.free.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    List<Teacher> findAllByPosition(String position);
}

