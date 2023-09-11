package classes;

public class Professor extends Funcionario{
    public String cpf;
    public String nome;
    public String rg;

    @Override
    public String toString() {
        return "Professor{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", rg='" + rg + '\'' +
                ", CodFuncionario='" + CodFuncionario + '\'' +
                '}';
    }
}
