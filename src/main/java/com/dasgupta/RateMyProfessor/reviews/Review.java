package com.dasgupta.RateMyProfessor.reviews;

import com.dasgupta.RateMyProfessor.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @NotNull
    private User student;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    @NotNull
    private User professor;

    @NotNull
    @Min(value = 1, message = "The rating should be between 1 and 5 stars")
    @Max(value = 5, message = "The rating should be between 1 and 5 stars")
    private Integer rating;

    private String comment;

    @Column(name = "created_at")
    @NotNull
    private LocalDateTime createdAt;

    // Default constructor
    public Review() {
    }

    // Constructor with fields
    public Review(User student, User professor, Integer rating, String comment) {
        this.student = student;
        this.professor = professor;
        this.rating = rating;
        this.comment = comment;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public User getProfessor() {
        return professor;
    }

    public void setProfessor(User professor) {
        this.professor = professor;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString method
    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", student=" + student.getId() +
                ", professor=" + professor.getId() +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}