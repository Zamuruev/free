/*
package miit.uvp.free.services.impl;

import miit.uvp.free.services.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService<Long> {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void expel(Long id){teacherRepository.deleteById(id);}
    @Override
    public Optional<TeacherDTO> findTeacher(Long id){return Optional.ofNullable(modelMapper.map(teacherRepository.findById(id),TeacherDTO.class));}
    @Override
    public Optional<TeacherDTO> getAll(){return teacherRepository.findAll().stream().map((s)->modelMapper.map(s,TeacherDTO.class)).collect(Collectors.toList());}

}
*/
