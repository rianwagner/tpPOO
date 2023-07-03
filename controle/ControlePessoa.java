package controle;

import modelo.Entidade;
import modelo.Pessoa;

public class ControlePessoa extends Controle {
    @Override
    public String cadastrar(Entidade entidade) {
        try {
            getDatabase().getPessoaPersistente().inserir(entidade);    
            return "";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            getDatabase().getPessoaPersistente().excluir(id);
            return "";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }

    public String alterar(int id, String nome, String CPF, String telefone) {
        Pessoa pessoaAux;
        try {
            pessoaAux = (Pessoa) getDatabase().getPessoaPersistente().buscarPorId(id);
            pessoaAux.setNome(nome);
            pessoaAux.setCpf(CPF);
            pessoaAux.setTelefone(telefone);
            return "";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    } 

    @Override
    public String buscarPorId(int id) {
        try {
            getDatabase().getPessoaPersistente().buscarPorId(id);
            return "";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }    
}