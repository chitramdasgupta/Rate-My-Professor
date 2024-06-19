package com.dasgupta.RateMyProfessor.user;

import com.dasgupta.RateMyProfessor.degree.Degree;
import com.dasgupta.RateMyProfessor.department.Department;
import com.dasgupta.RateMyProfessor.institution.Institution;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Institution institution;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Department department;

    @Enumerated(EnumType.STRING)
    private UserType type;

    @ManyToOne
    @JoinColumn(name = "highest_degree_id")
    private Degree highestDegree;

    @ManyToOne
    @JoinColumn(name = "pursuing_degree_id")
    private Degree pursuingDegree;

    // Boilerplate
    public User() {
    }

    public User(String firstName, String middleName, String lastName, Institution institution, Department department, UserType type, Degree highestDegree, Degree pursuingDegree) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.institution = institution;
        this.department = department;
        this.type = type;
        this.highestDegree = highestDegree;
        this.pursuingDegree = pursuingDegree;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public Degree getHighestDegree() {
        return highestDegree;
    }

    public void setHighestDegree(Degree highestDegree) {
        this.highestDegree = highestDegree;
    }

    public Degree getPursuingDegree() {
        return pursuingDegree;
    }

    public void setPursuingDegree(Degree pursuingDegree) {
        this.pursuingDegree = pursuingDegree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id != null && id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", institution=" + institution +
                ", department=" + department +
                ", type=" + type +
                '}';
    }
}