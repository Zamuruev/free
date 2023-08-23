package miit.uvp.free.models;

import jakarta.persistence.*;


@Entity
@Table(name = "teacher_subject")
public class TeacherSubject {

    @Id
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @Id
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public TeacherSubject(Teacher teacher, Subject subject) {
        this.teacher = teacher;
        this.subject = subject;
    }
    protected TeacherSubject() {}

    public Teacher getTeacher() { return teacher; }

    private void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() { return subject; }

    private void setSubject(Subject subject) {
        this.subject = subject;
    }
}
