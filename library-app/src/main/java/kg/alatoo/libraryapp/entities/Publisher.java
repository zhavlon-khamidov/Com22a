package kg.alatoo.libraryapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Publisher {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String email;

    @OneToMany(mappedBy = "publisher")
    Set<Book> books;

}
