package kg.alatoo.libraryapp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "writer")
public class Author {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "varchar(7)")
    private Long id;
    @Column(length = 100)
    private String fullName;
    @Column(name = "primary_email",
            unique = true,
            nullable = false)
    private String email;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;
}
