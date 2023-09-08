package miit.uvp.free.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subjects")
public class Subject extends BaseEntity {
    @Column(name = "counthours", nullable = false)
    private int counthours;

    @OneToMany(mappedBy = "id.subject",orphanRemoval = true)
    private Set<TeacherSubject> teacherSubjects;

    @OneToMany(mappedBy = "id.subject",orphanRemoval = true)
    private Set<SchoolClassSubject> schoolClassSubjects;

    public Subject(String name, int counthours) {
        this.counthours = counthours;
        this.name = name;
        this.teacherSubjects = new HashSet<TeacherSubject>();
    }

    public Subject() {}

    public int getCounthours() { return counthours; }

    private void setCounthours(int counthours) { this.counthours = counthours; }

    public Set<TeacherSubject> getTeacherSubjects() {
        return teacherSubjects;
    }

    public void setTeacherSubjects(Set<TeacherSubject> teacherSubjects) {
        this.teacherSubjects = teacherSubjects;
    }
}
