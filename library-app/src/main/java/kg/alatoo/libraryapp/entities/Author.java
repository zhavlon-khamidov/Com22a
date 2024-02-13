package kg.alatoo.libraryapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;
    private String fullName;
    private String email;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;
}
