package miit.uvp.free.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "teacher_subject")
public class TeacherSubject {

    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private Subject subject;

    @EmbeddedId
    private TeacherSubjectId id;

    public TeacherSubject() {
        this.id = new TeacherSubjectId();
    }

    // Остальные поля и методы

    @Embeddable
    public static class TeacherSubjectId implements Serializable {
        @ManyToOne
        private Teacher teacher;

        @ManyToOne
        @JoinColumn(name = "subject_id") // Добавьте это, чтобы избежать дублирования столбца
        private Subject subject;

        public Teacher getTeacher() {
            return teacher;
        }

        public void setTeacher(Teacher teacher) {
            this.teacher = teacher;
        }

        public Subject getSubject() {
            return subject;
        }

        public void setSubject(Subject subject) {
            this.subject = subject;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TeacherSubjectId)) return false;
            TeacherSubjectId that = (TeacherSubjectId) o;
            return Objects.equals(getTeacher(), that.getTeacher()) &&
                    Objects.equals(getSubject(), that.getSubject());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getTeacher(), getSubject());
        }
    }
}
