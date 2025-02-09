package project.kiii_project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.kiii_project.models.Review;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {
    List<Review> findByBookId(String bookId);
}