/*
package miit.uvp.free.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "students")
public class Student extends BaseEntity{
    private int age;
    @ManyToOne(optional = false)
    @JoinColumn(name = "schoolClass_id",referencedColumnName = "id",nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private SchoolClass schoolClass;

    public Student(int age){
        setAge(age);
    }
    protected Student(){};

    @Column(name="age",length = 2,nullable = false)

    public int getAge(){return age;}
    private void setAge(int age){this.age=age;}

    public SchoolClass getSchoolClass(){return schoolClass;}
    public void setSchoolClass(SchoolClass schoolClass){this.schoolClass=schoolClass;}

}
*/
