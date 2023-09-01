
package miit.uvp.free.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "schoolclass_teacher")
public class SchoolClassTeacher {

    @Embeddable
    public static class SchoolClassTeacherId implements Serializable {
        @ManyToOne
        @JoinColumn(name = "teacher_id")
        private Teacher teacher;

        @ManyToOne
        @JoinColumn(name = "school_class_id")
        private SchoolClass schoolClass;

        public SchoolClassTeacherId(Teacher teacher, SchoolClass schoolClass) {
            this.teacher = teacher;
            this.schoolClass = schoolClass;
        }

        public Teacher getTeacher() {
            return teacher;
        }

        public void setTeacher(Teacher teacher) {
            this.teacher = teacher;
        }

        public SchoolClass getSchoolClass() {
            return schoolClass;
        }

        public void setSchoolClass(SchoolClass schoolClass) {
            this.schoolClass = schoolClass;
        }
        public SchoolClassTeacherId() {
            // Пустой конструктор
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SchoolClassTeacherId that = (SchoolClassTeacherId) o;

            if (!Objects.equals(teacher.getId(), that.teacher.getId())) return false;
            return Objects.equals(schoolClass.getId(), that.schoolClass.getId());
        }

        @Override
        public int hashCode() {
            int result = teacher.getId() != null ? teacher.getId().hashCode() : 0;
            result = 31 * result + (schoolClass.getId() != null ? schoolClass.getId().hashCode() : 0);
            return result;
        }
    }

    @EmbeddedId
    private SchoolClassTeacherId id;

    public SchoolClassTeacher() {
        // Пустой конструктор
    }

    public SchoolClassTeacher(Teacher teacher, SchoolClass schoolClass) {
        this.id = new SchoolClassTeacherId(teacher, schoolClass);
    }

    public SchoolClassTeacherId getId() {
        return id;
    }

    public void setId(SchoolClassTeacherId id) {
        this.id = id;
    }
}
