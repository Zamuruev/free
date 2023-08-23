package miit.uvp.free.dtos;

public class SchoolClassTeacherDTO {

    private TeacherDTO teacher;
    private SchoolClassDTO schoolClass;

    public SchoolClassTeacherDTO(TeacherDTO teacher, SchoolClassDTO schoolClass) {
        this.teacher = teacher;
        this.schoolClass = schoolClass;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

    public SchoolClassDTO getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClassDTO schoolClass) {
        this.schoolClass = schoolClass;
    }
}
