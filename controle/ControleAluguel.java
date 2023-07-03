package controle;

import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Aluguel;
import modelo.Entidade;
import modelo.ItemAluguel;
import modelo.Pessoa;

public class ControleAluguel extends Controle {
    @Override
    public String cadastrar(Entidade entidade) {
        try {
            getDatabase().getAluguelPersistente().inserir(entidade);    
            return "";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            getDatabase().getAluguelPersistente().excluir(id);
            return "";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }

    public String alterar(int id, LocalDate dataInicio, LocalDate dataFim, Pessoa pessoa, ArrayList<ItemAluguel> carros) {
        Aluguel aluguelAux;
        try {
            aluguelAux = (Aluguel) getDatabase().getAluguelPersistente().buscarPorId(id);
            aluguelAux.setDataInicio(dataInicio);
            aluguelAux.setDataFim(dataFim);
            aluguelAux.setPessoa(pessoa);
            aluguelAux.setCarros(carros);
            return "";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    } 

    @Override
    public String buscarPorId(int id) {
        try {
            getDatabase().getAluguelPersistente().buscarPorId(id);
            return "";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }    
}