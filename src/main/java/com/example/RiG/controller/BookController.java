package com.example.RiG.controller;

import com.example.RiG.model.Book;
import com.example.RiG.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<Book> createBook(@RequestBody @Valid Book book) {
        Book response = bookService.createBook(book);

        if(response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/updateStock/{bookId}")
    public ResponseEntity<Book> updateBookStock(@PathVariable String bookId,
                                                @RequestParam int stock) {
        Book response = bookService.updateBookStock(bookId, stock);

        if(response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
