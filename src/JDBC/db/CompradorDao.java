package JDBC.db;

import JDBC.ConexaoFactory;
import JDBC.classes.Comprador;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CompradorDao {

    public static void save(Comprador comprador){
        String sql = "INSERT INTO comprador (cpf,nome,data_cadastro) VALUES (?, ?, ?)";

        try (PreparedStatement statement =  ConexaoFactory.getConexao().prepareStatement(sql)){
            if(statement != null){
                statement.setString(1, comprador.getCpf());
                statement.setString(2, comprador.getNome());
                statement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                statement.execute();
                System.out.println("Registro inserido com sucesso!");
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static  void update(Comprador comprador){
        String sql = "UPDATE comprador SET nome = ?, cpf = ?, data_atualizacao = ? WHERE id = ?";

        try (PreparedStatement statement =  ConexaoFactory.getConexao().prepareStatement(sql)){
            if(statement != null){
                statement.setString(1, comprador.getNome());
                statement.setString(2, comprador.getCpf());
                statement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                statement.setInt(4, comprador.getId());
                statement.execute();
                System.out.println("Registro atualizado com sucesso!");
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static  void delete(Comprador comprador){
        String sql = "DELETE FROM comprador WHERE id = ?";
        try (PreparedStatement statement =  ConexaoFactory.getConexao().prepareStatement(sql)){
            statement.setInt(1, comprador.getId());
            statement.executeQuery();
            System.out.println("Registro deletado com sucesso!");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public  static List<Comprador> selectAll(){
        String sql = "SELECT * FROM comprador";

        try (ResultSet resultSet = ConexaoFactory.getConexao().prepareStatement(sql).executeQuery()){
            if(resultSet != null){
                List<Comprador> compradorList = new ArrayList<>();
                while (resultSet.next()){
                    compradorList.add(extractOfResultSet(resultSet));
                }
                return compradorList;
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }

    private static Comprador extractOfResultSet(ResultSet resultSet) throws SQLException {
        resultSet.getInt("id");
        resultSet.getString("cpf");
        resultSet.getString("nome");
        resultSet.getTimestamp("data_cadastro");
        resultSet.getTimestamp("data_atualizacao");

        return new Comprador(
                resultSet.getInt("id"),
                resultSet.getString("cpf"),
                resultSet.getString("nome"),
                resultSet.getTimestamp("data_cadastro") != null ? resultSet.getTimestamp("data_cadastro").toLocalDateTime() : null,
                resultSet.getTimestamp("data_atualizacao") != null ? resultSet.getTimestamp("data_atualizacao").toLocalDateTime() : null
        );
    }
}
