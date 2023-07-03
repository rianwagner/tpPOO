package modelo;

public class ItemAluguel extends Entidade {
    private Carro carro;
    private double valorDiaria;

    public ItemAluguel(Carro carro) {
        this.carro = carro;
        this.valorDiaria = carro.getValorDiaria();
    }
    
    public Carro getCarro() { return this.carro; }
    public void setCarro(Carro carro) { this.carro = carro; }

    public double getValorDiaria() { return this.valorDiaria; }
    public void setValorDiaria(double valorDiaria) { this.valorDiaria = valorDiaria; };
}