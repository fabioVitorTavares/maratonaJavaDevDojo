package JDBC;

import JDBC.classes.Comprador;
import JDBC.db.CompradorDB;

import java.sql.Connection;

public class ConexaoTest {

    public static void main(String[] args) {
        CompradorDB compradorDB = new CompradorDB();
        Comprador comprador1 = new Comprador("00000000000", "Fabio");
        compradorDB.save(comprador1);

    }
}
