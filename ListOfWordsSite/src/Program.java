import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Program {
    static Scanner input = new Scanner(System.in);

    public static final String URL = "jdbc:mysql://localhost/ListOfWords";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    public static Connection connection;
    public static Statement statement;

    static {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String insert = "INSERT INTO words(word) VALUES('";
        String select = "SELECT * FROM words";

        while(true){
            String word = input.nextLine();

            if(word.isEmpty()) return;

            statement.executeUpdate(insert + word + "');");

            ResultSet resultSet = statement.executeQuery(select);
        }
    }
}
