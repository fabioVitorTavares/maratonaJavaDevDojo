package JDBC;

import JDBC.classes.Comprador;
import JDBC.db.CompradorDao;

import java.util.List;
import java.util.Scanner;

public class TestCrud {

    private static Scanner techado = new Scanner(System.in);
    public static void main(String[] args) {
        int op;
        while(true){
            menu();
            op = Integer.parseInt(techado.nextLine());
            if(op == 0){
                System.out.println("Saindo do sistema!");
                break;
            }else{
                executar(op);
            }


        }
    }

    public static  void executar(int op){
        switch (op){
            case 1:
                inserir();
                break;
            case 2:
                atualizar();
                break;
            case 3:
                listar();
                break;
            case 4:
                deletar();
                break;
        }
    }

    private static void inserir(){
        Comprador comprador = new Comprador();
        System.out.println("Nome: ");
        comprador.setNome(techado.nextLine());
        System.out.println("Cpf: ");
        comprador.setCpf(techado.nextLine());
        CompradorDao.save(comprador);
    }

    private  static  void atualizar(){
        System.out.println("Selecione um dos compradores abaixo");
        List<Comprador> compradorList = listar();
        Comprador comprador = compradorList.get(Integer.parseInt(techado.nextLine()));
        System.out.println("Novo nome ou enter para manter o mesmo");
        String nome = techado.nextLine();
        System.out.println("Novo cpf ou enter para manter o mesmo");
        String cpf = techado.nextLine();
        if (!nome.isEmpty()){
            comprador.setNome(nome);
        }
        if(!cpf.isEmpty()){
            comprador.setCpf(cpf);
        }
        CompradorDao.update(comprador);
    }

    private static List<Comprador> listar(){
        List<Comprador> compradorList = CompradorDao.selectAll();
        for(int i = 0; i< compradorList.size(); i++){
            Comprador comprador = compradorList.get(i);
            System.out.println("[" + i  + "] " + comprador.getNome() + " - " + comprador.getCpf());
        }
        return compradorList;
    }


    private  static void deletar(){
        System.out.println("Selecione um dos compradores abaixo para deletar");
        List<Comprador> compradorList = listar();
        Comprador comprador = compradorList.get(Integer.parseInt(techado.nextLine()));
        CompradorDao.delete(comprador);
    }
    private  static void menu(){
        System.out.println("Digite a opção para começar");
        System.out.println("1 Inserir Comprador");
        System.out.println("2 Atualizar Comprador");
        System.out.println("3 Listar Compradores");
        System.out.println("4 Deletar Comprador");
        System.out.println("0 Inserir Comprador");
    }
}
