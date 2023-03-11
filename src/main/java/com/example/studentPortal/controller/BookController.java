<<<<<<< HEAD
package com.example.studentPortal.controller;

import com.example.studentPortal.model.Book;
import com.example.studentPortal.service.BookService;
import jakarta.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/studentPortal")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping(value = "/book")
    public ResponseEntity saveBook(@RequestBody String bookData) {
        Book book = setBook(bookData);
        int Id = bookService.saveBook(book);
        return new ResponseEntity("book saved" + Id, HttpStatus.CREATED);
    }

    @GetMapping(value = "/book")
    public ResponseEntity<String> getBook(@Nullable @RequestParam String Id) {
        JSONArray bookDetails = bookService.getBook(Id);
        return new ResponseEntity(bookDetails.toString(), HttpStatus.OK);
    }

    @PutMapping(value = "/update-book/{Id}")
    public ResponseEntity<String> updateBook(@RequestBody String newBook, @PathVariable String Id) {
        Book book = setBook(newBook);
        bookService.updateBook(book, Id);
        return new ResponseEntity("book updated", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-book/{Id}")
    public ResponseEntity<String> deleteBook(@PathVariable String Id) {
        bookService.deleteBook(Id);
        return new ResponseEntity("book deleted", HttpStatus.OK);
    }

    private Book setBook(String bookData) {
        JSONObject object = new JSONObject(bookData);
        Book book = new Book();
        book.setTitle(object.getString("title"));
        book.setAuthor(object.getString("title"));
        book.setDescription(object.getString("description"));
        book.setPrice(object.getString("price"));

        return book;
    }
}
=======
package com.example.studentPortal.controller;

import com.example.studentPortal.model.Book;
import com.example.studentPortal.service.BookService;
import jakarta.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping(value = "/book")
    public ResponseEntity saveBook(@RequestBody String bookData) {
        Book book = setBook(bookData);
        String Id = bookService.saveBook(book);
        return new ResponseEntity("book saved" + Id, HttpStatus.CREATED);
    }

    @GetMapping(value = "/book")
    public ResponseEntity<String> getBook(@Nullable @RequestParam String Id) {
        JSONArray bookDetails = bookService.getBook(Id);
        return new ResponseEntity(bookDetails.toString(), HttpStatus.OK);
    }

    @PutMapping(value = "/update-book/{Id}")
    public ResponseEntity<String> updateBook(@RequestBody String newBook, @PathVariable String Id) {
        Book book = setBook(newBook);
        bookService.updateBook(book, Id);
        return new ResponseEntity("book updated", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-book/{Id}")
    public ResponseEntity<String> deleteBook(@PathVariable String Id) {
        bookService.deleteBook(Id);
        return new ResponseEntity("book deleted", HttpStatus.OK);
    }

    private Book setBook(String bookData) {
        JSONObject object = new JSONObject(bookData);
        Book book = new Book();
        book.setId(object.getString("Id"));
        book.setTitle(object.getString("title"));
        book.setAuthor(object.getString("title"));
        book.setDescription(object.getString("description"));
        book.setPrice(object.getString("price"));

        return book;
    }
}
>>>>>>> b8a4edad8d92aee6c0691373c4ff47bb81246d5f
