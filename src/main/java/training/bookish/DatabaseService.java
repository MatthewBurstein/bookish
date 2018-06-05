package training.bookish;

import models.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {

    private final String url;
    private final String username;
    private final String password;

    public DatabaseService(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        Book book;
        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM book")) {
            while (rs.next()) {
                book = new Book(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)
                );
                books.add(book);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return books;
    }
}
