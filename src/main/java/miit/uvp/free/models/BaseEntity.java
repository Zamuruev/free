package miit.uvp.free.models;

import jakarta.persistence.*;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    @Column(name = "name")
    protected String name;

    public Long getId() { return id; }

    protected void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    protected void setName(String name) { this.name = name; }
}
