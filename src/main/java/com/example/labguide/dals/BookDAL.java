package com.example.labguide.dals;

import com.example.labguide.model.Book;

import java.sql.*;
import java.util.ArrayList;

public class BookDAL {
    public ArrayList<Book> listBook() {
        Connection connection = DB.connect();
        ArrayList<Book> listBook = new ArrayList<Book>();
        try {
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
        Connection connection = DB.connect();
        try {
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
        Connection connection = DB.connect();
        try {
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
        Connection connection = DB.connect();
        try {
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
        Connection connection = DB.connect();
        Book book = null;
        try {
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

    public ArrayList<Book> searchBooks(String keyword) throws SQLException {
        Connection connection = DB.connect();
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM `books` WHERE `title` LIKE ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + keyword + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("title");
                    String bookCode = resultSet.getString("code");
                    String images = resultSet.getString("image");
                    double price = resultSet.getDouble("price");
                    Book book = new Book(id, name, bookCode, images, price);
                    books.add(book);
                }
            }
        }
        connection.close();
        return books;
    }

    public int getTotalRecord() {
        int total = 0;
        Connection connection = DB.connect();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("SELECT COUNT(*) AS total FROM books");
            ResultSet rs = prepareStatement.executeQuery();
            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return total;
    }

    public ArrayList<Book> getBookByOffsetAndPageSize(int offset, int pageSize) {
        ArrayList<Book> result = new ArrayList<Book>();
        Connection connection = DB.connect();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM books LIMIT ?, ?");
            prepareStatement.setInt(1, offset * pageSize);
            prepareStatement.setInt(2, pageSize);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                Book listBook = new Book();
                listBook.setId(rs.getInt("id"));
                listBook.setTitle(rs.getString("title"));
                listBook.setImage(rs.getString("image"));
                listBook.setPrice(rs.getDouble("price"));
                listBook.setCode(rs.getString("code"));
                result.add(listBook);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return result;
    }

}
