package miit.uvp.free.models;

import jakarta.persistence.*;

@Entity
@Table(name = "schoolclass_subject")
public class SchoolClassSubject {

    @Id
    @ManyToOne
    private Subject subject;

    @Id
    @ManyToOne
    private SchoolClass schoolClass;

    public SchoolClassSubject(Subject subject, SchoolClass schoolClass) {
        this.subject = subject;
        this.schoolClass = schoolClass;
    }

    protected SchoolClassSubject() {}

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

}
