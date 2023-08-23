
package miit.uvp.free.repositories;

import miit.uvp.free.models.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass,Long> {
    List<SchoolClass>findSchoolClassByName(String name);
    List<SchoolClass> findAll();


}
