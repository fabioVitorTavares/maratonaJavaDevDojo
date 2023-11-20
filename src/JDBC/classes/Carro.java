package JDBC.classes;

import java.time.LocalDateTime;
import java.util.Objects;

public class Carro {
    private Integer id;
    private  String nome;
    private  String placa;
    private LocalDateTime dataCadastro;
    private Integer compradorId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Integer getCompradorId() {
        return compradorId;
    }

    public void setCompradorId(Integer compradorId) {
        this.compradorId = compradorId;
    }

    public Carro(Integer id, String nome, String placa, LocalDateTime dataCadastro, Integer compradorId) {
        this.id = id;
        this.nome = nome;
        this.placa = placa;
        this.dataCadastro = dataCadastro;
        this.compradorId = compradorId;
    }

    public Carro(String nome, String placa, LocalDateTime dataCadastro, Integer compradorId) {
        this.nome = nome;
        this.placa = placa;
        this.dataCadastro = dataCadastro;
        this.compradorId = compradorId;
    }

    public Carro() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return Objects.equals(id, carro.id) && Objects.equals(nome, carro.nome) && Objects.equals(placa, carro.placa) && Objects.equals(dataCadastro, carro.dataCadastro) && Objects.equals(compradorId, carro.compradorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, placa, dataCadastro, compradorId);
    }
}
