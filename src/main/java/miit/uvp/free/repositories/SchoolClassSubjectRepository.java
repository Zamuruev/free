package miit.uvp.free.repositories;

import miit.uvp.free.models.SchoolClassSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassSubjectRepository extends JpaRepository<SchoolClassSubject, SchoolClassSubject.SchoolClassSubjectId> {
}
