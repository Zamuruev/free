
package miit.uvp.free.services.impl;

import miit.uvp.free.dtos.SchoolClassDTO;
import miit.uvp.free.dtos.SubjectDTO;
import miit.uvp.free.models.SchoolClass;
import miit.uvp.free.models.SchoolClassSubject;
import miit.uvp.free.models.Subject;
import miit.uvp.free.repositories.SchoolClassSubjectRepository;
import miit.uvp.free.repositories.SubjectRepository;
import miit.uvp.free.services.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService<Long> {
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SchoolClassSubjectRepository schoolClassSubjectRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public SubjectDTO register(SubjectDTO subjectDTO, List<SchoolClassDTO> schoolClasses) {
        Subject subject = new Subject(subjectDTO.getName(), subjectDTO.getCounthours());
        Subject savedSubject = subjectRepository.save(subject);

        for (SchoolClassDTO schoolClassDTO : schoolClasses) {
            SchoolClassSubject schoolClassSubject = new SchoolClassSubject(savedSubject, modelMapper.map(schoolClassDTO, SchoolClass.class));
            schoolClassSubjectRepository.save(schoolClassSubject);
        }

        return new SubjectDTO(savedSubject.getId(), savedSubject.getName(), savedSubject.getCounthours());
    }


    @Override
    public void expel(Long id){subjectRepository.deleteById(id);}

    @Override
    public Optional<SubjectDTO> findSubject(Long id){return Optional.ofNullable(modelMapper.map(subjectRepository.findById(id),SubjectDTO.class));}

    @Override
    public List<SubjectDTO> getAll(){return subjectRepository.findAll().stream().map((s)->modelMapper.map(s,SubjectDTO.class)).collect(Collectors.toList());}


}
