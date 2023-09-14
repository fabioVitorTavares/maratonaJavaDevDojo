package classes;

public class Professor extends Funcionario{

    public Professor(String cpf, String nome, String rg) {
        this.cpf = cpf;
        this.nome = nome;
        this.rg = rg;
    }

    public String cpf;
    public String nome;
    public String rg;


    public void alteraNome(){
        this.nome += " Alt";
    }

}
