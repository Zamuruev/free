package miit.uvp.free.services.impl;

import miit.uvp.free.dtos.SchoolClassDTO;
import miit.uvp.free.dtos.StudentDTO;
import miit.uvp.free.models.SchoolClass;
import miit.uvp.free.models.Student;
import miit.uvp.free.repositories.SchoolClassRepository;
import miit.uvp.free.repositories.StudentRepository;
import miit.uvp.free.services.StudentService;
import org.modelmapper.ModelMapper;
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
    public StudentDTO register(StudentDTO student) {
        Student s = modelMapper.map(student,Student.class);
        if(student.getSchoolClass().getId() != 0) {
            if(studentRepository.findAllBySchoolClassId(student.getSchoolClass().getId()).stream().toArray().length <= 2) {
                SchoolClass sc = schoolClassRepository.findById(student.getSchoolClass().getId()).get();
                s.setSchoolClass(sc);
                student = modelMapper.map(studentRepository.save(s),StudentDTO.class);
                System.out.println(studentRepository.findAllBySchoolClassId(student.getSchoolClass().getId()).stream().toArray().length);
            }
            else {
                System.out.println();
                System.out.println();
                System.out.printf("Студент %s не может быть добавлен в %s класс! Нет мест!",student.getName(), student.getSchoolClass().getName());
                System.out.println();
                System.out.println();
            }
        }
        return student;
    }

    @Override
    public void expel(Long id) { studentRepository.deleteById(id); }

    @Override
    public void transfer(StudentDTO student, SchoolClassDTO schoolClass) {
        Student s = studentRepository.findById(student.getId()).get();
        SchoolClass sch = schoolClassRepository.findById(schoolClass.getId()).get();
        s.setSchoolClass(sch);
        studentRepository.save(s);
    }

    @Override
    public Optional<StudentDTO> findStudent(Long id){
        return Optional.ofNullable(modelMapper.map(studentRepository.findById(id),StudentDTO.class));
    }

    @Override
    public List<StudentDTO> getAll(){
        return studentRepository.findAll().stream().map((s)->modelMapper.map(s,StudentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> findStudentsBySchoolClassName(String schoolclassName){
        return studentRepository.findAllBySchoolClassName(schoolclassName).stream().map((s)->modelMapper.map(s,StudentDTO.class)).collect(Collectors.toList());
    }
}
