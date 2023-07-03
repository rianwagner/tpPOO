package persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.Entidade;

public class Persistente {

    private List<Entidade> listaEntidades;

    public Persistente() {
        listaEntidades = new ArrayList<Entidade>();
    }

    public List<Entidade> getListaEntidades() { return this.listaEntidades; }

    public void inserir(Entidade entidade) {
        listaEntidades.add(entidade);
    }

    public void excluir(int id) {
        listaEntidades.removeIf(e -> e.getId() == id);
    }

    public Entidade buscarPorId(int id) throws ObjetoNaoEncontradoException {
        for (Entidade entidade : listaEntidades) {
            if (entidade.getId() == id) {
                return entidade;
            }
        }
        throw new ObjetoNaoEncontradoException(id);
    }

    public String toString() {
        for (Entidade objeto : listaEntidades) {
            System.out.println(objeto.toString());
        }
        return "\n";
    }
}
