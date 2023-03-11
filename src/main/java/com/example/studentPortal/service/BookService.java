<<<<<<< HEAD
package com.example.studentPortal.service;

import com.example.studentPortal.dao.BookRepository;
import com.example.studentPortal.dao.StudentRepository;
import com.example.studentPortal.model.Book;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public int saveBook(Book book) {
        Book book1 = bookRepository.save(book);
        return book1.getId();
    }

    public JSONArray getBook(String Id) {
        JSONArray books = new JSONArray();
        if(null != Id && bookRepository.findById(Integer.valueOf(Id)).isPresent()) {
            Book book = bookRepository.findById(Integer.valueOf(Id)).get();
            JSONObject object = setBook(book);
            books.put(object);
        }
        else {
            List<Book> bookList = bookRepository.findAll();
            for(Book book : bookList) {
                JSONObject object = setBook(book);
                books.put(book);
            }
        }
        return books;
    }

    private JSONObject setBook(Book book) {
        JSONObject object = new JSONObject();
        object.put("title", book.getTitle());
        object.put("author", book.getAuthor());
        object.put("description", book.getDescription());
        object.put("price", book.getPrice());
        object.put("student", book.getStudent());

        return object;
    }
    public void updateBook(Book newBook, String Id) {
        if(bookRepository.findById(Integer.valueOf(Id)).isPresent()) {
            bookRepository.save(newBook);
        }
    }

    public void deleteBook(String Id) {
        if(bookRepository.findById(Integer.valueOf(Id)).isPresent()) {
            Book book = bookRepository.findById(Integer.valueOf(Id)).get();
            bookRepository.delete(book);
        }
    }
}
=======
package com.example.studentPortal.service;

import com.example.studentPortal.dao.BookRepository;
import com.example.studentPortal.dao.StudentRepository;
import com.example.studentPortal.model.Book;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public String saveBook(Book book) {
        Book book1 = bookRepository.save(book);
        return book1.getId();
    }

    public JSONArray getBook(String Id) {
        JSONArray books = new JSONArray();
        if(null != Id && bookRepository.findById(Integer.valueOf(Id)).isPresent()) {
            Book book = bookRepository.findById(Integer.valueOf(Id)).get();
            JSONObject object = setBook(book);
            books.put(object);
        }
        else {
            List<Book> bookList = bookRepository.findAll();
            for(Book book : bookList) {
                JSONObject object = setBook(book);
                books.put(book);
            }
        }
        return books;
    }

    private JSONObject setBook(Book book) {
        JSONObject object = new JSONObject();
        object.put("Id", book.getId());
        object.put("title", book.getTitle());
        object.put("author", book.getAuthor());
        object.put("description", book.getDescription());
        object.put("price", book.getPrice());
        object.put("student", book.getStudent());

        return object;
    }
    public void updateBook(Book newBook, String Id) {
        if(bookRepository.findById(Integer.valueOf(Id)).isPresent()) {
            bookRepository.save(newBook);
        }
    }

    public void deleteBook(String Id) {
        if(bookRepository.findById(Integer.valueOf(Id)).isPresent()) {
            Book book = bookRepository.findById(Integer.valueOf(Id)).get();
            bookRepository.delete(book);
        }
    }
}
>>>>>>> b8a4edad8d92aee6c0691373c4ff47bb81246d5f
