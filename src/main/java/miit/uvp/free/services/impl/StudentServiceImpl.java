/*
package miit.uvp.free.services.impl;

import miit.uvp.free.dtos.StudentDTO;
import miit.uvp.free.models.SchoolClass;
import miit.uvp.free.models.Student;
import miit.uvp.free.repositories.SchoolClassRepository;
import miit.uvp.free.repositories.StudentRepository;
import miit.uvp.free.services.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService<Long> {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SchoolClassRepository schoolClassRepository;

    @Override
    public StudentDTO register(StudentDTO student){
        Student s = modelMapper.map(student,Student.class);
        if(student.getSchoolClass().getId()!=0){
            SchoolClass sc = schoolClassRepository.findById(student.getSchoolClass().getId()).get();
            s.setSchoolClass(sc);
        }
        return modelMapper.map(studentRepository.save(s),StudentDTO.class);
    }

    @Override
    public void expel(StudentDTO student){studentRepository.deleteById(student.getId());}

    @Override
    public Optional<StudentDTO> findStudent(Long id){
        return Optional.ofNullable(modelMapper.map(studentRepository.findById(id),StudentDTO.class));
    }

    @Override
    public List<StudentDTO> getAll(){
        return studentRepository.findAll().stream().map((s)->modelMapper.map(s,StudentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> findStudentsBySchoolClass(String schoolclass){
        return studentRepository.findAllBySchoolClassName(schoolclass).stream().map((s)->modelMapper.map(s,StudentDTO.class)).collect(Collectors.toList());
    }
}
*/
