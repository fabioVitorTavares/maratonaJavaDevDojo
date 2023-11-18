package JDBC.db;

import JDBC.ConexaoFactory;
import JDBC.classes.Comprador;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CompradorDB {
    public static void save(Comprador comprador){
        String sql = "INSERT INTO comprador (cpf,nome,data_cadastro) VALUES ('" + comprador.getCpf() + "','" + comprador.getNome() +"','" + comprador.getDataCadastro() + "')";
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

    public static  void delete(Comprador comprador){
        String sql = "DELETE FROM comprador WHERE id = " + comprador.getId();
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

    public static  void update(Comprador comprador){
        String sql = "UPDATE comprador SET nome = '" + comprador.getNome() + "', cpf = '" + comprador.getCpf() + "', data_atualizacao = '" + LocalDateTime.now() + "' WHERE id = " + comprador.getId();
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

    public  static List<Comprador> selectAll(){
        String sql = "SELECT * FROM comprador";
        Connection connection = ConexaoFactory.getConexao();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery(sql);
            List<Comprador> compradorList = new ArrayList<>();
            while (resultSet.next()){
                compradorList.add(extractOfResultSet(resultSet));
            }
            ConexaoFactory.closeConection(connection,statement, resultSet);
            return compradorList;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }

    public static  Comprador selectById(int id){
        String sql =  "SELECT * FROM comprador WHERE id = " + id;
        Connection connection = ConexaoFactory.getConexao();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery(sql);
            Comprador comprador = null;
            while(resultSet.next()){
                comprador = extractOfResultSet(resultSet);
            }
            ConexaoFactory.closeConection(connection,statement);
            return comprador;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static  List<Comprador> selectByNome(String nome){
        String sql =  "SELECT * FROM comprador WHERE nome ILIKE '%" + nome + "%'";
        Connection connection = ConexaoFactory.getConexao();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery(sql);
            List<Comprador> compradores = new ArrayList<>();
            while(resultSet.next()){
                compradores.add(extractOfResultSet(resultSet));
            }
            ConexaoFactory.closeConection(connection,statement);
            return compradores;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static  Comprador selectByCpf(String cpf){
        String sql =  "SELECT * FROM comprador WHERE cpf = '" + cpf + "'";
        Connection connection = ConexaoFactory.getConexao();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery(sql);
            Comprador comprador = null;
            while(resultSet.next()){
                comprador = extractOfResultSet(resultSet);
            }
            ConexaoFactory.closeConection(connection,statement);
            return comprador;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
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


    public static  void selectMetaData(){
        String sql =  "SELECT * FROM comprador";
        Connection connection = ConexaoFactory.getConexao();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery(sql);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            Comprador comprador = null;
            resultSet.next();
            int qtdColunas = resultSetMetaData.getColumnCount();
            System.out.println("Qtd Colunas: " + qtdColunas);
            for(int i = 1; i <= qtdColunas; i++){
                System.out.println("Tabela: " + resultSetMetaData.getTableName(i));
                System.out.println("Nome coluna:  " + resultSetMetaData.getColumnName(i));
                System.out.println("Tamanho coluna: " + resultSetMetaData.getColumnDisplaySize(i));
            }
            ConexaoFactory.closeConection(connection,statement);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public  static  void checkDriverStatus(){
        Connection connection = ConexaoFactory.getConexao();

        try {
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            if(databaseMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)){
                System.out.println("Suporta TYPE_FORWARD_ONLY");
                if(databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)){
                    System.out.println(" e também suporta CONCUR_UPDATABLE");
                }
            }
            if(databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)){
                System.out.println("Suporta TYPE_SCROLL_INSENSITIVE");
                if(databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
                    System.out.println(" e também suporta CONCUR_UPDATABLE");
                }
            }
            if(databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)){
                System.out.println("Suporta TYPE_SCROLL_SENSITIVE");
                if(databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){
                    System.out.println(" e também suporta CONCUR_UPDATABLE");
                }
            }

            ConexaoFactory.closeConection(connection);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public static  void testTypeScroll(){
        String sql =  "SELECT * FROM comprador ORDER BY id DESC";
        Connection connection = ConexaoFactory.getConexao();
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet =  statement.executeQuery(sql);

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            System.out.println(resultSetMetaData.toString());

            if(resultSet.first()){
                System.out.println(resultSet.getInt("id"));
            }
            ConexaoFactory.closeConection(connection,statement);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
