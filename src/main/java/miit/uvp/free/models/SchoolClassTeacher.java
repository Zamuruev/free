package miit.uvp.free.models;

import jakarta.persistence.*;

@Entity
@Table(name = "schoolclass_teacher")
public class SchoolClassTeacher {
    @Id
    @ManyToOne
    private Teacher teacher;

    @Id
    @ManyToOne
    private SchoolClass schoolClass;

    public SchoolClassTeacher(Teacher teacher, SchoolClass schoolClass) {
        this.teacher = teacher;
        this.schoolClass = schoolClass;
    }

    protected SchoolClassTeacher() {}

    public Teacher getTeacher() {
        return teacher;
    }

    private void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    private void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

}
