package miit.uvp.free.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher extends BaseEntity {

    // Должность
    @Column(name = "position")
    private String position;

    @OneToMany(mappedBy = "teacher")
    private Set<TeacherSubject> teacherSubjects;

    @OneToMany(mappedBy = "teacher")
    private Set<SchoolClassTeacher> schoolClassTeachers;

    public Teacher(String position, String name) {
        this.position = position;
        this.name = name;
        this.teacherSubjects = new HashSet<TeacherSubject>();
        this.schoolClassTeachers = new HashSet<SchoolClassTeacher>();
    }

    // Пустой конструктор для Hibernate
    protected Teacher() {}

    private void setPosition(String position) { this.position = position; }

    public String getPosition() { return position; }
}
