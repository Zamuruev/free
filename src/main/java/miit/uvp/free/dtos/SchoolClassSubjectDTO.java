package miit.uvp.free.dtos;

public class SchoolClassSubjectDTO {

    private SubjectDTO subject;
    private SchoolClassDTO schoolClass;

    public SchoolClassSubjectDTO(SubjectDTO subject, SchoolClassDTO schoolClass) {
        this.subject = subject;
        this.schoolClass = schoolClass;
    }

    public SubjectDTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
    }

    public SchoolClassDTO getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClassDTO schoolClass) {
        this.schoolClass = schoolClass;
    }
}
