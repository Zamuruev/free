package miit.uvp.free.services.impl;

import jakarta.persistence.EntityNotFoundException;
import miit.uvp.free.dtos.SubjectDTO;
import miit.uvp.free.dtos.TeacherDTO;
import miit.uvp.free.models.Subject;
import miit.uvp.free.models.Teacher;
import miit.uvp.free.models.TeacherSubject;
import miit.uvp.free.repositories.SubjectRepository;
import miit.uvp.free.repositories.TeacherRepository;
import miit.uvp.free.repositories.TeacherSubjectRepository;
import miit.uvp.free.services.TeacherSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeacherSubjectServiceImpl implements TeacherSubjectService {

    @Autowired
    private TeacherSubjectRepository teacherSubjectRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    @Transactional
    public void merge(SubjectDTO subjectDTO, TeacherDTO teacherDTO) {
        // Получаем учителя и предмет из DTO
        Teacher teacher = teacherRepository.findById(teacherDTO.getId()).orElseThrow(() -> new EntityNotFoundException("Teacher not found"));
        Subject subject = subjectRepository.findById(subjectDTO.getId()).orElseThrow(() -> new EntityNotFoundException("Subject not found"));

        // Создаем объект TeacherSubjectId
        TeacherSubject.TeacherSubjectId teacherSubjectId = new TeacherSubject.TeacherSubjectId(teacher, subject);

        // Создаем объект TeacherSubject с композитным ключом
        TeacherSubject teacherSubject = new TeacherSubject();
        teacherSubject.setId(teacherSubjectId);

        // Сохраняем связь
        teacherSubjectRepository.save(teacherSubject);

    }
}
