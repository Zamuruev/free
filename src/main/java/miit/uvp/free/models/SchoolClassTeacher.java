package miit.uvp.free.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "schoolclass_teacher")
public class SchoolClassTeacher {
    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private SchoolClass schoolClass;

    @EmbeddedId
    private SchoolClassTeacherId id;
    public SchoolClassTeacher(){this.id = new SchoolClassTeacherId();}

    @Embeddable
    public static class SchoolClassTeacherId implements Serializable{
        @ManyToOne
        private Teacher teacher;

        @ManyToOne
        @JoinColumn(name = "schoolclass_id")
        private SchoolClass schoolClass;

        public Teacher getTeacher(){return teacher;}

        public void setTeacher(Teacher teacher){this.teacher=teacher;}

        public SchoolClass getSchoolClass(){return schoolClass;}

        public void setSchoolClass(SchoolClass schoolClass){this.schoolClass=schoolClass;}

        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(!(o instanceof SchoolClassTeacherId)) return false;
            SchoolClassTeacherId that = (SchoolClassTeacherId) o;
            return Objects.equals(getTeacher(),that.getTeacher()) && Objects.equals(getSchoolClass(),that.getSchoolClass());
        }

        @Override
        public int hashCode(){return  Objects.hash(getTeacher(),getSchoolClass());}
    }
}
