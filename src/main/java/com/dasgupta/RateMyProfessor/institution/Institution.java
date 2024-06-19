package com.dasgupta.RateMyProfessor.institution;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    private String city;

    private String country;

    @Enumerated(EnumType.STRING)
    private InstitutionType type;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Institution parent;

    // Boilerplate
    public Institution() {
    }

    public Institution(String name, String city, String country, InstitutionType type, Institution parent) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.type = type;
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public InstitutionType getDescription() {
        return type;
    }

    public void setDescription(InstitutionType type) {
        this.type = type;
    }

    public Institution getParent() {
        return parent;
    }

    public void setParent(Institution parent) {
        this.parent = parent;
    }

    // equals() and hashCode() methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Institution that = (Institution) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    // toString() method

    @Override
    public String toString() {
        return "Institution{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", type=" + type +
                ", parent=" + (parent != null ? parent.getId() : null) +
                '}';
    }
}