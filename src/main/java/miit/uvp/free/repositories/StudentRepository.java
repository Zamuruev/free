package miit.uvp.free.repositories;

import miit.uvp.free.models.Student;
import miit.uvp.free.services.StudentService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student>findAllBySchoolClassName(String schoolClassName);
}