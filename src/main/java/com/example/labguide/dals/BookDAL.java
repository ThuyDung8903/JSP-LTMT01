package com.example.labguide.dals;

import com.example.labguide.model.Book;

import java.sql.*;
import java.util.ArrayList;

public class BookDAL {
    public ArrayList<Book> listBook() {
        ArrayList<Book> listBook = new ArrayList<Book>();
        try {
            Connection connection = DB.connect();
            String sql = "select * from books";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet != null) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String title = resultSet.getString("title");
                    String code = resultSet.getString("code");
                    String image = resultSet.getString("image");
                    double price = resultSet.getDouble("price");
                    Book book = new Book(id, title, code, image, price);
                    listBook.add(book);
                }
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBook;
    }

    public void addBook(Book book) {
        try {
            Connection connection = DB.connect();
            String sql = "INSERT INTO books (title, code, image, price) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getCode());
            statement.setString(3, book.getImage());
            statement.setDouble(4, book.getPrice());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int bookId) {
        try {
            Connection connection = DB.connect();
            String sql = "DELETE FROM books WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, bookId);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editBook(Book book) {
        try {
            Connection connection = DB.connect();
            String sql = "UPDATE books SET title=?, code=?, image=?, price=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getCode());
            statement.setString(3, book.getImage());
            statement.setDouble(4, book.getPrice());
            statement.setInt(5, book.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Book getBookById(int bookId) {
        Book book = null;
        try {
            Connection connection = DB.connect();
            String sql = "SELECT * FROM books WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, bookId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setCode(resultSet.getString("code"));
                book.setImage(resultSet.getString("image"));
                book.setPrice(resultSet.getDouble("price"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
}
