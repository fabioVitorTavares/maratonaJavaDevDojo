package JDBC;

import JDBC.classes.Comprador;
import JDBC.db.CompradorDB;

import java.sql.Connection;
import java.time.LocalDateTime;

public class ConexaoTest {

    private  final CompradorDB compradorDB = new CompradorDB();
    public static void main(String[] args) {

//        save(new Comprador("10000006", "MARIA",LocalDateTime.now()));
//        delete(new Comprador(4));
//         update(new Comprador(3, "000000", "ANA PAULA"));
//        selectAll();
//        selectById(3);
//        selectByNome("a");
//        selectByCpf("000000");
//        selectMetaData();
//        checkDriverStatus();
        testTypeScroll();
    }

    public static void save(Comprador comprador) {
        CompradorDB.save(comprador);
    }

    public static void delete(Comprador comprador ){
       CompradorDB.delete(comprador);
    }

    public static void update(Comprador comprador ){
       CompradorDB.update(comprador);
    }
    public static void selectAll(){
        System.out.println(CompradorDB.selectAll());
    }
    public static void selectById(int id){
        System.out.println(CompradorDB.selectById(id));
    }
    public static void selectByNome(String nome){
        System.out.println(CompradorDB.selectByNome(nome));
    }
    public static void selectByCpf(String cpf){
        System.out.println(CompradorDB.selectByCpf(cpf));
    }
    public static void selectMetaData(){
       CompradorDB.selectMetaData();
    }
    public static void checkDriverStatus(){
       CompradorDB.checkDriverStatus();
    }
    public static void testTypeScroll(){
       CompradorDB.testTypeScroll();
    }
}
