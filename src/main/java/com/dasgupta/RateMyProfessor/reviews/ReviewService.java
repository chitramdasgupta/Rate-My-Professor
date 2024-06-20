package com.dasgupta.RateMyProfessor.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAll() {
        return (List<Review>) reviewRepository.findAll();
    }

    public Optional<Review> getById(Long id) {
        return reviewRepository.findById(id);
    }
}
