package JDBC.classes;

import java.util.Objects;

public class Comprador {
    private int id;
    private String cpf;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Comprador(int id, String cpf, String nome) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
    }
    public Comprador( String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
    public Comprador() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comprador comprador = (Comprador) o;
        return id == comprador.id && Objects.equals(cpf, comprador.cpf) && Objects.equals(nome, comprador.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
