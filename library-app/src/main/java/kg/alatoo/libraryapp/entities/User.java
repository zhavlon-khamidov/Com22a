package kg.alatoo.libraryapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @Column(unique = true)
    @Size(min = 3,max = 25)
    @Pattern(regexp = "^[a-z0-9_]+$")
    private String username;
    private String password;

    @Email
    private String email;

}
