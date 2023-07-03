package controle;

import modelo.Entidade;
import persistencia.Database;

// classe abstrata para generalizar o uso da camada de controle
public abstract class Controle {
    protected Database database;

    public Controle() {
        this.database = Database.getDatabase();
    }

    public Database getDatabase() { return this.database; }

    public abstract String cadastrar(Entidade entidade);
    public abstract String excluir(int id);
    public abstract String buscarPorId(int id);
}