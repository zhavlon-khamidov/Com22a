package kg.alatoo.libraryapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@ToString
public class Publisher {

    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private String address;
    private String email;

    @OneToMany(mappedBy = "publisher")
    Set<Book> books;

}
