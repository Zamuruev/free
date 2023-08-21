package miit.uvp.free.repositories;

import miit.uvp.free.models.SchoolClass;
import miit.uvp.free.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass,Long> {
}
