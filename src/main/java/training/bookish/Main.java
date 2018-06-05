package training.bookish;

import java.sql.*;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        DatabaseService db = new DatabaseService();
        db.testConnection();
    }
}
