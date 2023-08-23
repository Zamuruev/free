package miit.uvp.free.services.impl;

import com.fasterxml.jackson.annotation.OptBoolean;
import miit.uvp.free.services.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService<Long> {
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void expel(Long id){subjectRepository.deleteById(id);}

    @Override
    public Optional<SubjectDTO> findSubject(Long id){return Optional.ofNullable(modelMapper.map(subjectRepository.findById(id),SubjectDTO.class));}

    @Override
    public List<SubjectDTO> getAll(){return subjectRepository.findAll().stream().map((s)->modelMapper.map(s,SubjectDTO.class)).collect(Collectors.toList());}


}
