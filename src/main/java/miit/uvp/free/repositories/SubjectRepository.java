package miit.uvp.free.repositories;

import miit.uvp.free.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
    List<Subject> findAllByCounthoursOrderByNameAsc(int counthours);
}

