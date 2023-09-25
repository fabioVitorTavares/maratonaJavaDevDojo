package classes;

public class Estudante {

    public Estudante(String nome, int idade, int... notas ){
        this.nome = nome;
        this.idade = idade;
        this.notas = notas;
    }
    public String nome;
    public int idade;
    public int[] notas;


    public void printDados(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);

        double soma = 0;
        for(double nota: notas){
            soma += nota;
        }
        double media = soma / notas.length;
        boolean aprovado = media > 6;
        System.out.println(("Média: " +  String.format("%.2f",media) + " ") + ( aprovado ? "Aprovado" : "Reprovado"));
    }
}
