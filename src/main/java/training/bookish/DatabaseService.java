package training.bookish;

import models.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {

    private final String url;
    private final String username;
    private final String password;

    public DatabaseService() {
        this.url = "jdbc:postgresql://localhost:5432/bookish";
        this.username = System.getenv("POSTGRES_USERNAME");
        this.password = System.getenv("POSTGRES_PASSWORD");
    }

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM book")) {
            Book book = null;
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
