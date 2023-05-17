import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        final String password = "421243266";
        final String user = "postgres";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)"))
        {
            statement.setInt(1, 1);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Имя :       " + resultSet.getString("first_name"));
                System.out.println("Фамилия :   " + resultSet.getString("last_name"));
                System.out.println("Пол :       " + resultSet.getString("gender"));

                System.out.println("Возраст :   " + resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        {

        }
    }
}
