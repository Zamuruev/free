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

}
