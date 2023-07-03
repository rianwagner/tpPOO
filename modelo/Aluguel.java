package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aluguel extends Entidade {
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Pessoa pessoa;
    private List<ItemAluguel> carros = new ArrayList<>();

    public Aluguel(LocalDate dataInicio, LocalDate dataFim, Pessoa pessoa, List<ItemAluguel> carros) {
        super();
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.pessoa = pessoa;
        this.carros = carros;
    }

    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }

    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }

    public Pessoa getPessoa() { return pessoa; }
    public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }

    public List<ItemAluguel> getCarros() { return carros; }
    public void setCarros(List<ItemAluguel> carros) { this.carros = carros; }

    public void addCarro(ItemAluguel carro) {
        this.carros.add(carro);
    }
    
    public void removeCarro(ItemAluguel carro) {
        this.carros.remove(carro);
    }

    public double calculaTotal() {
        double valorTotal = 0;
        for (int i = 0; i <= getId(); i++) {
            for (ItemAluguel aux : carros) {
                if (i == aux.getId()) {
                    valorTotal += aux.getValorDiaria();
                }
            }
        }
        return valorTotal;
    }

    public String toString() {
        return "\nAluguel [" +
                "id = " + getId() +
                ", dataInicio = " + dataInicio +
                ", dataFim = " + dataFim +
                ", pessoa = " + pessoa +
                ", carros = " + carros + 
                ", valor total = " + calculaTotal() + " ]";
    }
}
