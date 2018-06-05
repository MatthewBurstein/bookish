package training.bookish;

import java.sql.*;

public class DatabaseService {

    private final String url;
    private final String username;
    private final String password;

    public DatabaseService() {
        this.url = "jdbc:postgresql://localhost:5432/bookish";
        this.username = System.getenv("POSTGRES_USERNAME");
        this.password = System.getenv("POSTGRES_PASSWORD");
    }

    public void testConnection() {
        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM book")) {

            if (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
