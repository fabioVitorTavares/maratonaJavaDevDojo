package teste;

import classes.Professor;

import java.util.Objects;

public class TesteProfessor {
    public static void main(String[] args) {
        Professor professor = new Professor("12576264697", "Fabio V", "123456");


        System.out.println(professor.nome);

        professor.alteraNome();
        System.out.println(professor.nome);
    }
}
