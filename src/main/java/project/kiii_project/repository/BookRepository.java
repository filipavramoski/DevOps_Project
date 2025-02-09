package project.kiii_project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.kiii_project.models.Book;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByAuthorId(String authorId);
}
