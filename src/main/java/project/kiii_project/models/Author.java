package project.kiii_project.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//chanheeees
@Data
@Document(collection = "authors")
public class Author {
    @Id
    private String id;
    private String name;
    private String biography;
}