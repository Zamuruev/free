package miit.uvp.free.init;

import miit.uvp.free.dtos.SchoolClassDTO;
import miit.uvp.free.dtos.StudentDTO;
import miit.uvp.free.dtos.SubjectDTO;
import miit.uvp.free.dtos.TeacherDTO;
import miit.uvp.free.models.TeacherSubject;
import miit.uvp.free.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Autowired
    private StudentService studentService;

    @Autowired
    private SchoolClassService schoolClassService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private TeacherSubjectService teacherSubjectService;


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() throws IOException {

        // Создание класса
        SchoolClassDTO schoolClass1 = new SchoolClassDTO();
        schoolClass1.setName("10A");
        SchoolClassDTO saveSchoolClass1 = schoolClassService.register(schoolClass1);

        // Создание класса
        SchoolClassDTO schoolClass2 = new SchoolClassDTO();
        schoolClass2.setName("11Б");
        SchoolClassDTO saveSchoolClass2 = schoolClassService.register(schoolClass2);

        // Создание класса
        SchoolClassDTO schoolClass3 = new SchoolClassDTO();
        schoolClass3.setName("9В");
        SchoolClassDTO saveSchoolClass3 = schoolClassService.register(schoolClass3);

        // Создание класса
        SchoolClassDTO schoolClass4 = new SchoolClassDTO();
        schoolClass4.setName("7А");
        SchoolClassDTO saveSchoolClass4 = schoolClassService.register(schoolClass4);

        // Создание студентов
        StudentDTO student1 = new StudentDTO();
        student1.setName("Замуруев Роман Романович");
        student1.setLearnBasis("Бюджет");
        student1.setSchoolClass(saveSchoolClass2);
        studentService.register(student1);

        StudentDTO student2 = new StudentDTO();
        student2.setName("Иванов Иван Иванович");
        student2.setLearnBasis("Коммерция");
        student2.setSchoolClass(saveSchoolClass2);
        studentService.register(student2);

        StudentDTO student3 = new StudentDTO();
        student3.setName("Брежнева Алена Владимировна");
        student3.setLearnBasis("Бюджет");
        student3.setSchoolClass(saveSchoolClass2);
        studentService.register(student3);

        StudentDTO student4 = new StudentDTO();
        student4.setName("Кривоногов Петр Николаевич");
        student4.setLearnBasis("Коммерция");
        student4.setSchoolClass(saveSchoolClass2);
        studentService.register(student4);

        // Создание преподавателей
        TeacherDTO teacher1 = new TeacherDTO();
        teacher1.setName("Заманов Дмитрий Альбертович");
        teacher1.setPosition("Ассистент");

        List<SchoolClassDTO> schoolClassDTOList = new ArrayList<>();

        schoolClassDTOList.add(saveSchoolClass1);
        schoolClassDTOList.add(saveSchoolClass2);
        teacher1 = teacherService.register(teacher1, schoolClassDTOList);

        TeacherDTO teacher2 = new TeacherDTO();
        teacher2.setName("Новиков Александр Иванович");
        teacher2.setPosition("Старший преподаватель");
        teacher2 = teacherService.register(teacher2,schoolClassDTOList);

        List<SchoolClassDTO> schoolClassDTOList1 = new ArrayList<>();

        schoolClassDTOList1.add(saveSchoolClass3);
        schoolClassDTOList1.add(saveSchoolClass4);

        // Создание предметов
        SubjectDTO subject1 = new SubjectDTO();
        subject1.setCounthours(20);
        subject1.setName("Математика");
        subject1 = subjectService.register(subject1,schoolClassDTOList1);

        SubjectDTO subject2 = new SubjectDTO();
        subject2.setCounthours(15);
        subject2.setName("Физика");
        subject2 = subjectService.register(subject2,schoolClassDTOList);

        teacherSubjectService.merge(subject1,teacher2);
        teacherSubjectService.merge(subject2,teacher1);
        teacherSubjectService.merge(subject1,teacher1);

    }
}
