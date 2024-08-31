package bcom.service;

import bcom.model.Book;

import java.util.List;

public interface BookService {

     void addBook(Book book);

     void deleteBook(int id);

     void updateBook(Book book,int id);

     List<Book> getAllBook();
}
