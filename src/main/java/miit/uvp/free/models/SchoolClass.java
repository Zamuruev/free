
package miit.uvp.free.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import java.util.Set;



import java.util.HashSet;

@Entity
@Table(name = "schoolclasses")
public class SchoolClass extends BaseEntity{

    private int countst;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "schoolClass")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Student> students;

    public SchoolClass(int countst){
        setCountst(countst);
        students = new HashSet<Student>();
    }
    protected SchoolClass(){}

    @Column(name = "count of students",length = 2,nullable = false)
    public int getCountst(){return countst;}
    public void setCountst(int countst){this.countst=countst;}
    public Set<Student> getStudents(){return students;}
    public void setStudents(Set<Student> students){this.students= students;}

}
