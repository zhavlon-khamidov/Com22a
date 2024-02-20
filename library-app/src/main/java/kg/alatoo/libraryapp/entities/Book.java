package kg.alatoo.libraryapp.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "title_ed",columnNames = {"title","edition"}))
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private int publishedYear;
    private String isbn;
    private int edition;

    @ManyToOne
    private Publisher publisher;

    @ManyToMany
    private List<Author> authors;

}
