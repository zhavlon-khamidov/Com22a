package kg.alatoo.libraryapp.mappers;

import kg.alatoo.libraryapp.dto.BookDTO;
import kg.alatoo.libraryapp.entities.Book;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BookMapper {

    @Mapping(target = "authors", ignore = true)
    @Mapping(source = "name", target = "title")
    @Mapping(target = "publisher.books", ignore = true)
    Book bookDtoToBook(BookDTO dto);

    @InheritInverseConfiguration
    @Mapping(target = "publisher.books", ignore = true)
    BookDTO bookToBookDto(Book book);

    //TODO: refactor bookDto so book stores publisherId instead of publisherDto

}
