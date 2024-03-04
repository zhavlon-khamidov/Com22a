package kg.alatoo.libraryapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private Long id;
    @NotNull
    @NotBlank
    @Size(max = 20)
    private String name;

    private int publishedYear;
//    @ISBN
    private String isbn;
    @Positive
    @Builder.Default
    private int edition=1;

    private PublisherDTO publisher;
}
