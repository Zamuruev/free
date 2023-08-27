package miit.uvp.free.services.impl;

import miit.uvp.free.dtos.SubjectDTO;
import miit.uvp.free.dtos.TeacherDTO;
import miit.uvp.free.models.Subject;
import miit.uvp.free.models.Teacher;
import miit.uvp.free.models.TeacherSubject;
import miit.uvp.free.repositories.SubjectRepository;
import miit.uvp.free.repositories.TeacherRepository;
import miit.uvp.free.repositories.TeacherSubjectRepository;
import miit.uvp.free.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService<Long> {

    private final TeacherRepository teacherRepository;
    private final TeacherSubjectRepository teacherSubjectRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository, TeacherSubjectRepository teacherSubjectRepository) {
        this.teacherRepository = teacherRepository;
        this.teacherSubjectRepository = teacherSubjectRepository;
    }

    @Override
    public TeacherDTO register(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher(teacherDTO.getPosition(), teacherDTO.getName());
        Teacher savedTeacher = teacherRepository.save(teacher);
        return new TeacherDTO(savedTeacher.getId(), savedTeacher.getName(), savedTeacher.getPosition());
    }

    @Override
    public void expel(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public void expel(TeacherDTO teacherDTO) {
        teacherRepository.deleteById(teacherDTO.getId());
    }

    @Override
    public Optional<TeacherDTO> findTeacher(Long id) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        return teacherOptional.map(teacher -> new TeacherDTO(teacher.getId(), teacher.getName(), teacher.getPosition()));
    }

    @Override
    public List<TeacherDTO> getAll() {
        List<Teacher> teachers = teacherRepository.findAll();
        List<TeacherDTO> teacherDTOs = new ArrayList<>();
        for (Teacher teacher : teachers) {
            teacherDTOs.add(new TeacherDTO(teacher.getId(), teacher.getName(), teacher.getPosition()));
        }
        return teacherDTOs;
    }

    @Override
    public List<TeacherDTO> findTeachersBySchoolClassName(String name) {
        // Реализуйте логику поиска преподавателей по названию класса
        // Вероятно, это потребует использования других репозиториев и сущностей
        return new ArrayList<>();
    }

    @Override
    public List<TeacherDTO> findTeachersBySubjectName(String name) {
        List<Teacher> teachers = teacherSubjectRepository.findTeachersBySubjectName(name);
        List<TeacherDTO> teacherDTOs = new ArrayList<>();
        for (Teacher teacher : teachers) {
            teacherDTOs.add(new TeacherDTO(teacher.getId(), teacher.getName(), teacher.getPosition()));
        }
        return teacherDTOs;
    }
}
