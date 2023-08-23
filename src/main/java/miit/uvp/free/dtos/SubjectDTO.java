package miit.uvp.free.dtos;

public class SubjectDTO {
    private Long id;
    private String name;
    private int counthours;

    public SubjectDTO(Long id, String name, int counthours) {
        this.id = id;
        this.name = name;
        this.counthours = counthours;
    }
    public SubjectDTO() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getCounthours() { return counthours; }

    public void setCounthours(int counthours) { this.counthours = counthours; }

}
