package org.pbp.reviewservice.repository;

import org.pbp.reviewservice.document.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends MongoRepository<Review, String> {
}
