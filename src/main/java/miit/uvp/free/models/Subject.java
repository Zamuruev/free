package miit.uvp.free.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "subjects")
public class Subject extends BaseEntity  {

    // Количество часов
    @Column(name = "counthours")
    private int counthours;

    public Subject(int counthours) {
        this.counthours = counthours;
    }

    @OneToMany(mappedBy = "subject")
    private List<TeacherSubject> teacherSubjects;

    protected Subject() {}

    public int getCounthours() { return counthours; }

    private void setCounthours(int counthours) { this.counthours = counthours; }
}
