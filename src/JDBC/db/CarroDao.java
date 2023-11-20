package JDBC.db;

import JDBC.ConexaoFactory;
import JDBC.classes.Carro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CarroDao {

    public static void save(Carro carro){
        String sql = "INSERT INTO carro (placa,nome,data_cadastro, comprador_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement =  ConexaoFactory.getConexao().prepareStatement(sql)){
            if(statement != null){
                statement.setString(1, carro.getPlaca());
                statement.setString(2, carro.getNome());
                statement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                statement.setInt(4, carro.getCompradorId());
                statement.execute();
                System.out.println("Registro inserido com sucesso!");
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static  void update(Carro carro){
        String sql = "UPDATE carro SET nome = ?, placa = ? WHERE id = ?";

        try (PreparedStatement statement =  ConexaoFactory.getConexao().prepareStatement(sql)){
            if(statement != null){
                statement.setString(1, carro.getNome());
                statement.setString(2, carro.getPlaca());
                statement.setInt(3, carro.getId());
                statement.execute();
                System.out.println("Registro atualizado com sucesso!");
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static  void delete(Carro carro){
        String sql = "DELETE FROM carro WHERE id = ?";
        try (PreparedStatement statement =  ConexaoFactory.getConexao().prepareStatement(sql)){
            statement.setInt(1, carro.getId());
            statement.executeQuery();
            System.out.println("Registro deletado com sucesso!");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public  static List<Carro> selectAll(){
        String sql = "SELECT * FROM carro";

        try (ResultSet resultSet = ConexaoFactory.getConexao().prepareStatement(sql).executeQuery()){
            if(resultSet != null){
                List<Carro> carroList = new ArrayList<>();
                while (resultSet.next()){
                    carroList.add(extractOfResultSet(resultSet));
                }
                return carroList;
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }

    private static Carro extractOfResultSet(ResultSet resultSet) throws SQLException {
        resultSet.getInt("id");
        resultSet.getString("placa");
        resultSet.getString("nome");
        resultSet.getTimestamp("data_cadastro");

        return new Carro(
                resultSet.getInt("id"),
                resultSet.getString("placa"),
                resultSet.getString("nome"),
                resultSet.getTimestamp("data_cadastro") != null ? resultSet.getTimestamp("data_cadastro").toLocalDateTime() : null,
                resultSet.getInt("comprador_id")
        );
    }
}
