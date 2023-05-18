package dao.impls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    private static final String password = "421243266";
    private static final String user = "postgres";
    private final String driver = "org.postgresql.Driver";
    private static final String url = "jdbc:postgresql://localhost:5432/skypro";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
