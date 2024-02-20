package kg.alatoo.libraryapp.mappers;

import kg.alatoo.libraryapp.dto.BookDTO;
import kg.alatoo.libraryapp.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BookMapper {

    @Mapping(source = "name", target = "title")
    Book bookDtoToBook(BookDTO dto);

    @Mapping(target = "name", source = "title")
    BookDTO bookToBookDto(Book book);
}
