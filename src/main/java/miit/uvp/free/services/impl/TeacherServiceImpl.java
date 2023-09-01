package miit.uvp.free.services.impl;

import jakarta.persistence.EntityNotFoundException;
import miit.uvp.free.dtos.SchoolClassDTO;
import miit.uvp.free.dtos.TeacherDTO;
import miit.uvp.free.models.SchoolClass;
import miit.uvp.free.models.SchoolClassTeacher;
import miit.uvp.free.models.Teacher;
import miit.uvp.free.repositories.SchoolClassRepository;
import miit.uvp.free.repositories.SchoolClassTeacherRepository;
import miit.uvp.free.repositories.TeacherRepository;
import miit.uvp.free.services.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService<Long> {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SchoolClassTeacherRepository schoolClassTeacherRepository;

    @Autowired
    private SchoolClassRepository schoolClassRepository;


    @Override
    @Transactional
    public TeacherDTO register(TeacherDTO teacherDTO, List<SchoolClassDTO> schoolClasses) {
        Teacher teacher = new Teacher(teacherDTO.getPosition(), teacherDTO.getName());
        Teacher savedTeacher = teacherRepository.save(teacher);

        for (SchoolClassDTO schoolClassDTO : schoolClasses) {
            SchoolClassTeacher.SchoolClassTeacherId schoolClassTeacherId = new SchoolClassTeacher.SchoolClassTeacherId(savedTeacher, modelMapper.map(schoolClassDTO, SchoolClass.class));
            SchoolClassTeacher schoolClassTeacher = new SchoolClassTeacher();
            schoolClassTeacher.setId(schoolClassTeacherId);

            schoolClassTeacherRepository.save(schoolClassTeacher);
        }

        return new TeacherDTO(savedTeacher.getId(), savedTeacher.getName(), savedTeacher.getPosition());
    }



    @Override
    @Transactional
    public void expel(Long id) {
        /*Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if (teacherOptional.isPresent()) {
            Teacher teacher = teacherOptional.get();

            // Найдем все связи SchoolClassTeacher с этим преподавателем
            List<SchoolClassTeacher> schoolClassTeachers = schoolClassTeacherRepository.findById_Teacher(teacher);

            for (SchoolClassTeacher schoolClassTeacher : schoolClassTeachers) {
                SchoolClassTeacher.SchoolClassTeacherId idToRemove = schoolClassTeacher.getId();

                // Создаем новый экземпляр SchoolClassTeacher без этого преподавателя
                SchoolClassTeacher newSchoolClassTeacher = new SchoolClassTeacher();
                newSchoolClassTeacher.setId(idToRemove);

                // Удаляем старый экземпляр SchoolClassTeacher
                schoolClassTeacherRepository.delete(schoolClassTeacher);

                // Сохраняем новый экземпляр SchoolClassTeacher
                schoolClassTeacherRepository.save(newSchoolClassTeacher);
            }

            // По желанию, можно также обработать связи TeacherSubject здесь

            teacherRepository.delete(teacher);
        } else {
            // Обработка случая, когда преподаватель не найден
        }*/
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
        /*List<Teacher> teachers = teacherSubjectRepository.findTeachersBySubjectName(name);
        List<TeacherDTO> teacherDTOs = new ArrayList<>();
        for (Teacher teacher : teachers) {
            teacherDTOs.add(new TeacherDTO(teacher.getId(), teacher.getName(), teacher.getPosition()));
        }
        return teacherDTOs;*/
        return null;
    }
}
