package JDBC;

import JDBC.classes.Comprador;
import JDBC.db.CompradorDBOld;

public class ConexaoTest {

    private  final CompradorDBOld compradorDB = new CompradorDBOld();
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
//        testTypeScroll();
//        System.out.println(CompradorDB.selectByNomePreparedStatement("be"));
//        CompradorDB.updatePreparedStatement(new Comprador(5, "JORGE", "1235465"));
            CompradorDBOld.saveCallable("Pedro Silva");
    }


    public static void save(Comprador comprador) {
        CompradorDBOld.save(comprador);
    }

    public static void delete(Comprador comprador ){
       CompradorDBOld.delete(comprador);
    }

    public static void update(Comprador comprador ){
       CompradorDBOld.update(comprador);
    }
    public static void selectAll(){
        System.out.println(CompradorDBOld.selectAll());
    }
    public static void selectById(int id){
        System.out.println(CompradorDBOld.selectById(id));
    }
    public static void selectByNome(String nome){
        System.out.println(CompradorDBOld.selectByNome(nome));
    }
    public static void selectByCpf(String cpf){
        System.out.println(CompradorDBOld.selectByCpf(cpf));
    }
    public static void selectMetaData(){
       CompradorDBOld.selectMetaData();
    }
    public static void checkDriverStatus(){
       CompradorDBOld.checkDriverStatus();
    }
    public static void testTypeScroll(){
       CompradorDBOld.testTypeScroll();
    }
}
