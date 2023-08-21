package miit.uvp.free.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher extends BaseEntity {

    // Должность
    @Column(name = "position")
    private String position;

    @OneToMany(mappedBy = "teacher")
    private List<TeacherSubject> teacherSubjects;

    @OneToMany(mappedBy = "teacher")
    private List<SchoolClassTeacher> schoolClassTeachers;

    public Teacher(String position) {
        this.position = position;
    }

    // Пустой конструктор для Hibernate
    protected Teacher() {    }

    private void setPosition(String position) { this.position = position; }

    public String getPosition() { return position; }
}
