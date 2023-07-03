package controle;

import modelo.Carro;
import modelo.Entidade;

public class ControleCarro extends Controle {
    @Override
    public String cadastrar(Entidade entidade) {
        try {
            getDatabase().getCarroPersistente().inserir(entidade);    
            return "";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            getDatabase().getCarroPersistente().excluir(id);
            return "";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }

    public String alterar(int id, String modelo, String marca, int ano, double valorDiaria) {
        Carro carroAux;
        try {
            carroAux = (Carro) getDatabase().getCarroPersistente().buscarPorId(id);
            carroAux.setModelo(modelo);
            carroAux.setMarca(marca);
            carroAux.setAno(ano);
            carroAux.setValorDiaria(valorDiaria);
            return "";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String buscarPorId(int id) {
        try {
            getDatabase().getCarroPersistente().buscarPorId(id);
            return "";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }    
}