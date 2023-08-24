package miit.uvp.free.services.impl;

import miit.uvp.free.dtos.SchoolClassDTO;
import miit.uvp.free.models.SchoolClass;
import miit.uvp.free.repositories.SchoolClassRepository;
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
    public List<SchoolClassDTO> findSchoolClassByStudent(String nameStudent){
        return schoolClassRepository.findSchoolClassByName(nameStudent).stream().map((s)->modelMapper.map(s,SchoolClassDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void expel(Long id){schoolClassRepository.deleteById(id);}

    @Override
    public SchoolClassDTO register(SchoolClassDTO schoolClass){
        SchoolClass sc = modelMapper.map(schoolClass,SchoolClass.class);
        return modelMapper.map(schoolClassRepository.save(sc),SchoolClassDTO.class);
    }

}
