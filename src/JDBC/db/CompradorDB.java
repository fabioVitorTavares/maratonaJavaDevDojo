package JDBC.db;

import JDBC.ConexaoFactory;
import JDBC.classes.Comprador;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CompradorDB {
    public void save(Comprador comprador){
        String sql = "INSERT INTO comprador (cpf,nome) VALUES ('" + comprador.getCpf() + "','" + comprador.getNome() +"')";
        System.out.println(sql);
        Connection connection = ConexaoFactory.getConexao();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            ConexaoFactory.closeConection(connection,statement);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
