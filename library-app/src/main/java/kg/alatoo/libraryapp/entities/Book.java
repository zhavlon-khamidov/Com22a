package kg.alatoo.libraryapp.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "title_ed",columnNames = {"title","edition"}))
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 20, message = "Title length not to be greater than 20")
    @Column(length = 20)
    private String title;
    private int publishedYear;
    private String isbn;
    private int edition;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Publisher publisher;

    @ManyToMany
    private List<Author> authors;

}
