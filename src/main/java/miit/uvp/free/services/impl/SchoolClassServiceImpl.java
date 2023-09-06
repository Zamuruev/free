package miit.uvp.free.services.impl;

import miit.uvp.free.dtos.SchoolClassDTO;
import miit.uvp.free.dtos.TeacherDTO;
import miit.uvp.free.models.SchoolClass;
import miit.uvp.free.models.Student;
import miit.uvp.free.models.Teacher;
import miit.uvp.free.repositories.SchoolClassRepository;
import miit.uvp.free.repositories.StudentRepository;
import miit.uvp.free.services.SchoolClassService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SchoolClassServiceImpl implements SchoolClassService<Long> {
    @Autowired
    private SchoolClassRepository schoolClassRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<SchoolClassDTO> getAll(){
        return schoolClassRepository.findAll().stream().map((s)->modelMapper.map(s,SchoolClassDTO.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<SchoolClassDTO> findSchoolClass(Long id){
        return Optional.ofNullable(modelMapper.map(schoolClassRepository.findById(id),SchoolClassDTO.class));
    }

    @Override
    public Optional<SchoolClassDTO> findSchoolClassByStudentId(Long id) {
        Optional<Student> s = studentRepository.findById(id);
        if(s.isPresent()) {
            Student st = s.get();
            Optional<SchoolClass> schoolClassOptional = schoolClassRepository.findById(st.getSchoolClass().getId());
            return schoolClassOptional.map(schoolClass -> new SchoolClassDTO(schoolClass.getId(),schoolClass.getName()));
        }
        return null;
    }

    @Override
    public void expel(Long id) { schoolClassRepository.deleteById(id); }

    @Override
    public SchoolClassDTO register(SchoolClassDTO schoolClass){
        SchoolClass sc = modelMapper.map(schoolClass,SchoolClass.class);
        return modelMapper.map(schoolClassRepository.save(sc),SchoolClassDTO.class);
    }

}
