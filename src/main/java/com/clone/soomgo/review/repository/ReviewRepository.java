package com.clone.soomgo.review.repository;

import com.clone.soomgo.review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
