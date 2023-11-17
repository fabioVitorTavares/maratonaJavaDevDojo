package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;


public class ConexaoFactory {

    public static Connection getConexao() {
        String url = "jdbc:postgresql://localhost:5432/agencia";
        String user = "postgres";
        String password = "postgres";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection ok: " + connection);
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void closeConection(Connection connection){
        try {
            if(connection != null){
                connection.close();
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void closeConection(Connection connection, Statement statement){
        closeConection(connection);
        try {
            if(statement != null){
                statement.close();
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
