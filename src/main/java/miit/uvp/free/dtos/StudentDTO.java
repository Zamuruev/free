
package miit.uvp.free.dtos;

public class StudentDTO {
    private Long id;
    private String name;
    private SchoolClassDTO schoolClass;

    public StudentDTO(Long id, String name, SchoolClassDTO schoolClass){
        this.id= id;
        this.name=name;
        this.schoolClass=schoolClass;
    }
    public StudentDTO() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public SchoolClassDTO getSchoolClass() { return schoolClass; }

    public void setSchoolClass(SchoolClassDTO schoolClass) {
        this.schoolClass = schoolClass;
    }
}

