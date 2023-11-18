package JDBC.classes;

import java.time.LocalDateTime;
import java.util.Objects;

public class Comprador {
    private int id;
    private String cpf;
    private String nome;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;


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

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Comprador(String cpf, String nome, LocalDateTime dataCadastro) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
    }

    public Comprador(int id, String cpf, String nome) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
    }

    public Comprador(int id, String cpf, String nome, LocalDateTime dataCadastro, LocalDateTime dataAtualizacao) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Comprador(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Comprador{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }
}
