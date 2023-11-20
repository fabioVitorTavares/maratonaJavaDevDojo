package JDBC;

import JDBC.classes.Carro;
import JDBC.db.CarroDao;

import java.util.List;
import java.util.Scanner;

public class TestCrudCarro {
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
            Carro carro = new Carro();
            System.out.println("Nome: ");
            carro.setNome(techado.nextLine());
            System.out.println("Placa: ");
            carro.setPlaca(techado.nextLine());
            System.out.println("Comprador: ");
            carro.setCompradorId(Integer.parseInt(techado.nextLine()));
            CarroDao.save(carro);
        }

        private  static  void atualizar(){
            System.out.println("Selecione um dos carroes abaixo");
            List<Carro> carroList = listar();
            Carro carro = carroList.get(Integer.parseInt(techado.nextLine()));
            System.out.println("Novo nome ou enter para manter o mesmo");
            String nome = techado.nextLine();
            System.out.println("Novo placa ou enter para manter o mesmo");
            String placa = techado.nextLine();
            if (!nome.isEmpty()){
                carro.setNome(nome);
            }
            if(!placa.isEmpty()){
                carro.setPlaca(placa);
            }
            CarroDao.update(carro);
        }

        private static List<Carro> listar(){
            List<Carro> carroList = CarroDao.selectAll();
            for(int i = 0; i< carroList.size(); i++){
                Carro carro = carroList.get(i);
                System.out.println("[" + i  + "] " + carro.getNome() + " - " + carro.getPlaca());
            }
            return carroList;
        }


        private  static void deletar(){
            System.out.println("Selecione um dos carroes abaixo para deletar");
            List<Carro> carroList = listar();
            Carro carro = carroList.get(Integer.parseInt(techado.nextLine()));
            CarroDao.delete(carro);
        }
        private  static void menu(){
            System.out.println("Digite a opção para começar");
            System.out.println("1 Inserir Carro");
            System.out.println("2 Atualizar Carro");
            System.out.println("3 Listar Carroes");
            System.out.println("4 Deletar Carro");
            System.out.println("0 Inserir Carro");
        }
    }
