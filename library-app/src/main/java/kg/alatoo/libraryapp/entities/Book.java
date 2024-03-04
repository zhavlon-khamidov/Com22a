package kg.alatoo.libraryapp.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull
    @NotBlank
    @Size(max = 20, message = "Title length not to be greater than 20")
    @Column(length = 20)
    private String title;
    private int publishedYear;
    private String isbn;
    private int edition;

    @ManyToOne
    private Publisher publisher;

    @ManyToMany
    private List<Author> authors;

}
