package in.advertiss.springjpahibernate.controller;

import in.advertiss.springjpahibernate.bean.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {

    @GetMapping("/books")
    public List<Book> getBooks(){
        return Arrays.asList(new Book(111l, "Spring Boot 2.20", "OReilly"));
    }
}
