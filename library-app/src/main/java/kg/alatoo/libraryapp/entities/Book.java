package kg.alatoo.libraryapp.entities;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Book {


    private Long id;
    private String title;
    private int publishedYear;
    private String isbn;
    private int edition;

//    private Publisher publisher;
//
//    private List<Author> authors;

}
