
package miit.uvp.free.repositories;

import miit.uvp.free.models.SchoolClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass,Long> {
    List<SchoolClass> findAll();
    Optional<SchoolClass> findById(Long id);
}
