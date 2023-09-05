
package miit.uvp.free.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;
import java.util.Set;

import java.util.HashSet;

@Entity
@Table(name = "schoolclasses")
public class SchoolClass extends BaseEntity {
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "schoolClass")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Student> students;

    @OneToMany(mappedBy = "id.schoolClass", cascade = CascadeType.ALL)
    private List<SchoolClassTeacher> schoolClassTeachers;

    @OneToMany(mappedBy = "id.schoolClass")
    private List<SchoolClassSubject> schoolClassSubjects;

    public SchoolClass(String name){
        setName(name);
        students = new HashSet<Student>();
    }
    public SchoolClass() {}

    public Set<Student> getStudents() { return students; }

    public void setStudents(Set<Student> students) {
        this.students = students;

    }
}

