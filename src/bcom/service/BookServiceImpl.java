package bcom.service;

import bcom.db.ConnectionDto;
import bcom.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements  BookService{
    ConnectionDto connectionDto = new ConnectionDto();

    @Override
    public void addBook(Book book) {
        String addQuery="Insert into book values(?,?,?,?)";


        try( Connection connection = connectionDto.getConnection();
         PreparedStatement pstm=connection.prepareStatement(addQuery)){

            pstm.setInt(1,book.getBookId());
            pstm.setString(2,book.getBookName());
            pstm.setInt(3,book.getBookPrice());
            pstm.setString(4,book.getAuthor());
            pstm.executeUpdate();
            System.out.println("successfully added the book!!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteBook(int id) {

        String delQuery="delete from book where id=?";
        try( Connection connection = connectionDto.getConnection();
             PreparedStatement pstm=connection.prepareStatement(delQuery)) {
            pstm.setInt(1,id);
             int delCount= pstm.executeUpdate();
             if(delCount==0){
                 System.out.println(" no such id found");
             }else{
                 System.out.println("book with id" + id +"deleted!!");
             }
        }catch(SQLException e){
            System.out.println(e.getMessage()+"cannot connect to the database");
        }


    }

    @Override
    public void updateBook(Book book,int id) {

        String updateQuery= "update book set  name=?,  author=?, price =? where id=?";
        try( Connection connection = connectionDto.getConnection();
             PreparedStatement pstm=connection.prepareStatement(updateQuery)){
            pstm.setString(1,book.getBookName());
            pstm.setString(2,book.getAuthor());
            pstm.setInt(3,book.getBookPrice());
            pstm.setInt(4,id);
            int updateCount=pstm.executeUpdate();
            if(updateCount==0){
                System.out.println("cannot find such id");
            }else{
                System.out.println("updated success id=" +id);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage()+"cant connect to db");
        }

    }

    @Override
    public List<Book> getAllBook() {
        List<Book> bookList= new ArrayList<>();
        String getQuery= "select * from book";
        try(Connection connection = connectionDto.getConnection();
        Statement statement = connection.createStatement()){
            ResultSet rs= statement.executeQuery(getQuery);
            while (rs.next()){
                int id= rs.getInt(1);
                String name=rs.getString(2);
                int price=rs.getInt(3);
                String author=rs.getString(4);
                Book book = new Book(id,name,price,author);
                bookList.add(book);
            }

        }catch (SQLException e){
            throw  new RuntimeException();
        }
        return bookList;
    }
}
