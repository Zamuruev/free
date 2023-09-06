package miit.uvp.free.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher extends BaseEntity {

    // Должность

    private String position;

    @OneToMany(mappedBy = "id.teacher",orphanRemoval = true)
    private Set<TeacherSubject> teacherSubjects;

    @OneToMany(mappedBy = "id.teacher",orphanRemoval = true)
    private Set<SchoolClassTeacher> schoolClassTeachers;

    public Teacher(String position, String name) {
        this.position = position;
        this.name = name;
        this.teacherSubjects = new HashSet<TeacherSubject>();
        this.schoolClassTeachers = new HashSet<SchoolClassTeacher>();
    }

    // Пустой конструктор для Hibernate
    public Teacher() {}

    private void setPosition(String position) { this.position = position; }

    public String getPosition() { return position; }
}
