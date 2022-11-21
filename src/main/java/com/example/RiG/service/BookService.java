package com.example.RiG.service;

import com.example.RiG.model.Book;
import com.example.RiG.repository.IBookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final IBookRepository bookRepository;

    public Book createBook(Book book) {
        if(bookRepository.findByName(book.getName()).isPresent()) { //Book already in stock
            Book bookInDb = bookRepository.findByName(book.getName()).get();
            bookInDb.setStock(bookInDb.getStock() + book.getStock());
            bookRepository.save(bookInDb);
            log.info("Book {}'s stock increased by {}, Current Stock: {}",
                    book.getName(), book.getStock(), bookInDb.getStock());

        } else if (book != null && book.getStock() > 0){ //New book
            bookRepository.save(book);
            log.info("Book added successfully with name: {}", book.getName());
        } else {
            log.error("Invalid book!");
            return null;
        }
        return book;
    }

    public Book updateBookStock(String bookIdStr, int stock) {
        long bookId;

        if(isNumeric(bookIdStr)) {
            bookId = Long.parseLong(bookIdStr);
        } else {
            log.error("{}: Invalid bookId");
            return null;
        }

        if(bookRepository.findById(bookId).isPresent() && stock >= 0) {
            Book bookDb = bookRepository.findById(bookId).get();
            bookDb.setStock(stock);
            bookRepository.save(bookDb);
            log.info("Book {}'s Current Stock: {}",
                    bookDb.getName(), bookDb.getStock());
            return bookDb;
        }

        log.error("Invalid operation!");
        return null;
    }

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            long num = Long.parseLong(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
