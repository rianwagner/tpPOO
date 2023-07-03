package modelo;

public class Carro extends Entidade {
    private String modelo;
    private String marca;
    private int ano;
    private double valorDiaria;
    private boolean disponivel;

    public Carro(String modelo, String marca, int ano, double valorDiaria) {
        super();
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
        this.disponivel = true;
    }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public double getValorDiaria() { return valorDiaria; }
    public void setValorDiaria(double valorDiaria) { this.valorDiaria = valorDiaria; }

    public boolean getDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    public String toString() {
        return "\nCarro [id = " + getId() +
                ", modelo = " + modelo +
                ", marca = " + marca +
                ", ano = " + ano +
                ", valorDiaria = " + valorDiaria +
                ", disponivel = " + disponivel + "]";
    }
}
