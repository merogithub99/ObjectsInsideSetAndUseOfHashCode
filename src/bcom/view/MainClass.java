package bcom.view;

import bcom.model.Book;
import bcom.service.BookService;
import bcom.service.BookServiceImpl;

import java.util.List;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        addBtn();
        delBtn();
        updateBtn();
        getBooksBtn();

    }

    static void addBtn() {
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();

        BookService bookService = new BookServiceImpl();
        char flag = 'y';

        System.out.println("do you want to add any book?y/n");
        flag = scanner.nextLine().charAt(0);
        if (flag == 'y') {
            do {

                System.out.println("enter the id of book");
                book.setBookId(scanner.nextInt());
                scanner.nextLine();
                System.out.println("enter the name of book");
                book.setBookName(scanner.nextLine());
                System.out.println("enter the price of book");
                book.setBookPrice(scanner.nextInt());
                scanner.nextLine();
                System.out.println("enter the author of book");
                book.setAuthor(scanner.nextLine());
                bookService.addBook(book);

                System.out.println("Do you want to add more?y/n");
                flag = scanner.nextLine().charAt(0);


            } while (flag == 'y');
        }

    }

    static void delBtn() {

        char flag = 'y';
        Scanner scanner = new Scanner(System.in);
        System.out.println("do you want to delete any book?y/n");
        flag = scanner.nextLine().charAt(0);
        if (flag == 'y') {
            BookService bookService = new BookServiceImpl();
            System.out.println("enter the id of the book you want to deleted");
            bookService.deleteBook(scanner.nextInt());
        }


    }

    static void updateBtn() {
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        BookService bookService = new BookServiceImpl();
        char flag = 'y';
        System.out.println("do you want to update any book?y/n");
        flag = scanner.nextLine().charAt(0);
        if (flag == 'y') {
            System.out.println("Enter the id of the book you want to update");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the updated name:");
            book.setBookName(scanner.nextLine());
            System.out.println("Enter the updated price ");
            book.setBookPrice(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Enter the updated author");
            book.setAuthor(scanner.nextLine());
            bookService.updateBook(book, id);
        }
    }

    static void getBooksBtn() {
        System.out.println("list of books");
        BookService bookService = new BookServiceImpl();
        List<Book> bookList = bookService.getAllBook();
        bookList.forEach((System.out::println));
//      bookList.forEach((book -> System.out.println(book)));

    }
}
