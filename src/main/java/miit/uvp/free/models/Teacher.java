package miit.uvp.free.models;

import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher extends BaseEntity {

    // Должность
    @Column(name = "position")
    private String position;

    public Teacher(String position) {
        this.position = position;
    }

    // Пустой конструктор для Hibernate
    protected Teacher() {    }

    private void setPosition(String position) { this.position = position; }

    public String getPosition() { return position; }
}
