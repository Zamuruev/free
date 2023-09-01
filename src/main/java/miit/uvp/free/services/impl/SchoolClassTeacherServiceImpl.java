/*
package miit.uvp.free.services.impl;

import jakarta.persistence.EntityNotFoundException;
import miit.uvp.free.dtos.SchoolClassDTO;
import miit.uvp.free.dtos.SchoolClassTeacherDTO;
import miit.uvp.free.dtos.TeacherDTO;
import miit.uvp.free.models.SchoolClass;
import miit.uvp.free.models.SchoolClassTeacher;
import miit.uvp.free.models.Teacher;
import miit.uvp.free.repositories.SchoolClassRepository;
import miit.uvp.free.repositories.SchoolClassTeacherRepository;
import miit.uvp.free.repositories.TeacherRepository;
import miit.uvp.free.services.SchoolClassTeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolClassTeacherServiceImpl implements SchoolClassTeacherService {

    @Autowired
    private SchoolClassTeacherRepository schoolClassTeacherRepository;

    @Autowired
    private SchoolClassRepository schoolClassRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public void assignTeacherToSchoolClass(TeacherDTO teacherDTO, SchoolClassDTO schoolClassDTO) {
        Long teacherId = teacherDTO.getId();
        Long schoolClassId = schoolClassDTO.getId();

        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new EntityNotFoundException("Teacher not found"));
        SchoolClass schoolClass = schoolClassRepository.findById(schoolClassId).orElseThrow(() -> new EntityNotFoundException("SchoolClass not found"));

        // Проверяем, не существует ли уже связи
        if (!schoolClassTeacherRepository.existsById_TeacherIdAndId_SchoolClassId(teacherId, schoolClassId)) {
            SchoolClassTeacher schoolClassTeacher = new SchoolClassTeacher(teacher, schoolClass);
            schoolClassTeacherRepository.save(schoolClassTeacher);
        }
    }

    @Override
    @Transactional
    public void removeTeacherFromSchoolClass(TeacherDTO teacherDTO, SchoolClassDTO schoolClassDTO) {
        Long teacherId = teacherDTO.getId();
        Long schoolClassId = schoolClassDTO.getId();

        // Удаляем связь, если она существует
        Teacher teacher = new Teacher();
        teacher.setId(teacherId);

        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setId(schoolClassId);

        schoolClassTeacherRepository.deleteById_TeacherAndId_SchoolClass(teacher, schoolClass);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isTeacherAssignedToSchoolClass(TeacherDTO teacherDTO, SchoolClassDTO schoolClassDTO) {
        Long teacherId = teacherDTO.getId();
        Long schoolClassId = schoolClassDTO.getId();

        return schoolClassTeacherRepository.existsById_TeacherIdAndId_SchoolClassId(teacherId, schoolClassId);
    }

    @Override
    public List<SchoolClassTeacherDTO> findByTeacher(TeacherDTO teacherDTO) {
        Teacher teacherEntity = modelMapper.map(teacherDTO, Teacher.class);

        List<SchoolClassTeacher> schoolClassTeachers = schoolClassTeacherRepository.findById_Teacher(teacherEntity);

        List<SchoolClassTeacherDTO> schoolClassTeacherDTOs = schoolClassTeachers.stream()
                .map(sct -> modelMapper.map(sct, SchoolClassTeacherDTO.class))
                .collect(Collectors.toList());

        return schoolClassTeacherDTOs;
    }



}
*/
