package classes;

public class Carro {

    private String marca;

    private String modelo;

    private Integer motor;
    public Carro(String marca, String modelo){
        this.marca = marca;
        this.modelo = modelo;
    }

    public Carro(Integer motor){
        this.motor = motor;
    }

    public Carro(String marca, String modelo, Integer motor){
        this(marca, modelo);
        this.motor = motor;
    }
    public void imprime(){
        System.out.println(this.marca);
        System.out.println(this.modelo);
        System.out.println(this.motor);
    }

}
