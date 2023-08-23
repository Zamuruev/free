package miit.uvp.free.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolClassSubject extends JpaRepository<SchoolClassSubject,Long> {
    List<SchoolClassSubject> findAllBySchoolClassName(String name);

}
