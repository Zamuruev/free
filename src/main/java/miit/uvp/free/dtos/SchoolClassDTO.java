package miit.uvp.free.dtos;

public class SchoolClassDTO {
    private Long id;
    private String name;

    public SchoolClassDTO(Long id,String name){
        setId(id);
        setName(name);
    }
    public SchoolClassDTO(){}


    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

}
