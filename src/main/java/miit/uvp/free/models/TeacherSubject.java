package miit.uvp.free.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "teacher_subject")
public class TeacherSubject {
    @Embeddable
    public static class TeacherSubjectId implements Serializable {
        @ManyToOne
        @JoinColumn(name = "teacher_id")
        private Teacher teacher;

        @ManyToOne
        @JoinColumn(name = "subject_id")
        private Subject subject;

        public TeacherSubjectId() {
            // Пустой конструктор
        }

        public TeacherSubjectId(Teacher teacher, Subject subject) {
            this.teacher = teacher;
            this.subject = subject;
        }

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
            if (o == null || getClass() != o.getClass()) return false;

            TeacherSubjectId that = (TeacherSubjectId) o;

            if (!Objects.equals(teacher.getId(), that.teacher.getId())) return false;
            return Objects.equals(subject.getId(), that.subject.getId());
        }

        @Override
        public int hashCode() {
            int result = teacher.getId() != null ? teacher.getId().hashCode() : 0;
            result = 31 * result + (subject.getId() != null ? subject.getId().hashCode() : 0);
            return result;
        }
    }

    @EmbeddedId
    private TeacherSubjectId id;

    public TeacherSubject() {
        // Пустой конструктор
    }

    public TeacherSubject(Teacher teacher, Subject subject) {
        this.id = new TeacherSubjectId(teacher, subject);
    }

    public TeacherSubjectId getId() {
        return id;
    }

    public void setId(TeacherSubjectId id) {
        this.id = id;
    }
}
