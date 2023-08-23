package miit.uvp.free.dtos;

public class TeacherSubjectDTO {

    private TeacherDTO teacher;
    private SubjectDTO subject;

    public TeacherSubjectDTO(TeacherDTO teacher, SubjectDTO subject) {
        this.teacher = teacher;
        this.subject = subject;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

    public SubjectDTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
    }
}
