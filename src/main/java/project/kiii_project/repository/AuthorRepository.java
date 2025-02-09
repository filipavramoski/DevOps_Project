package project.kiii_project.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import project.kiii_project.models.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {
}