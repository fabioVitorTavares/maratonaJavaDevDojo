package teste;

import classes.Professor;

import java.util.Objects;

public class TesteProfessor {
    public static void main(String[] args) {
        Professor professor = new Professor();
        Professor professor2 = new Professor();

        professor.cpf = "12576264697";
        professor.nome = "Fabio";
        professor.rg = "1255658145";

        professor2.cpf = "12576264697";
        professor2.nome = "Fabio";
        professor2.rg = "1255658145";

        professor.CodFuncionario = "252525";
        System.out.println(professor.toString());
    }
}
