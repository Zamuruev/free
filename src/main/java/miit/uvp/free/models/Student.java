
package miit.uvp.free.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;


@Entity
@Table(name = "students")
public class Student extends BaseEntity {

    // Основа обучения
    private String learnBasis;
    @ManyToOne(optional = false)
    @JoinColumn(name = "schoolClass_id",referencedColumnName = "id",nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private SchoolClass schoolClass;

    public Student(String learnBasis, String name){
        setLearnBasis(learnBasis);
        setName(name);
    }
    protected Student(){};

    public String getLearnBasis() {
        return learnBasis;
    }

    private void setLearnBasis(String learnBasis) {
        this.learnBasis = learnBasis;
    }

    public SchoolClass getSchoolClass(){ return schoolClass; }

    public void setSchoolClass(SchoolClass schoolClass){this.schoolClass=schoolClass;}

    @Override
    public String toString() {
        return "Student: id = " + id + ", name = " + name + ", class = " + schoolClass.name;
    }

}

