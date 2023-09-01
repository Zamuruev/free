package miit.uvp.free.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "schoolclass_subject")
public class SchoolClassSubject {

    @Embeddable
    public static class SchoolClassSubjectId implements Serializable {
        @ManyToOne
        @JoinColumn(name = "subject_id")
        private Subject subject;

        @ManyToOne
        @JoinColumn(name = "school_class_id")
        private SchoolClass schoolClass;

        public SchoolClassSubjectId(Subject subject, SchoolClass schoolClass) {
            this.subject = subject;
            this.schoolClass = schoolClass;
        }

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

        public SchoolClassSubjectId() {
            // Пустой конструктор
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SchoolClassSubjectId that = (SchoolClassSubjectId) o;

            if (!Objects.equals(subject.getId(), that.subject.getId())) return false;
            return Objects.equals(schoolClass.getId(), that.schoolClass.getId());
        }

        @Override
        public int hashCode() {
            int result = subject.getId() != null ? subject.getId().hashCode() : 0;
            result = 31 * result + (schoolClass.getId() != null ? schoolClass.getId().hashCode() : 0);
            return result;
        }
    }

    @EmbeddedId
    private SchoolClassSubjectId id;

    public SchoolClassSubject() {
        // Пустой конструктор
    }

    public SchoolClassSubject(Subject subject, SchoolClass schoolClass) {
        this.id = new SchoolClassSubjectId(subject, schoolClass);
    }

    public SchoolClassSubjectId getId() {
        return id;
    }

    public void setId(SchoolClassSubjectId id) {
        this.id = id;
    }

    public Subject getSubject() {
        return id.getSubject();
    }

    public void setSubject(Subject subject) {
        id.setSubject(subject);
    }

    public SchoolClass getSchoolClass() {
        return id.getSchoolClass();
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        id.setSchoolClass(schoolClass);
    }
}
