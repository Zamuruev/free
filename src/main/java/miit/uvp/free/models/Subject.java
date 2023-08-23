package miit.uvp.free.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subjects")
public class Subject extends BaseEntity {

    // Количество часов
    @Column(name = "counthours", nullable = false)
    private int counthours;

    @OneToMany(mappedBy = "subject")
    private Set<TeacherSubject> teacherSubjects;

    public Subject(int counthours) {
        this.counthours = counthours;
        this.teacherSubjects = new HashSet<TeacherSubject>();
    }

    protected Subject() {}

    public int getCounthours() { return counthours; }

    private void setCounthours(int counthours) { this.counthours = counthours; }

    public Set<TeacherSubject> getTeacherSubjects() {
        return teacherSubjects;
    }

    public void setTeacherSubjects(Set<TeacherSubject> teacherSubjects) {
        this.teacherSubjects = teacherSubjects;
    }
}
