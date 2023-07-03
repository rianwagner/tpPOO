package persistencia;

public class Database {
    private static final Database database = new Database(); // padrão Singleton para uma única instância do BD

    private Persistente pessoaPersistente;
    private Persistente carroPersistente;
    private Persistente aluguelPersistente;

    private Database() {
        pessoaPersistente = new Persistente();
        carroPersistente = new Persistente();
        aluguelPersistente = new Persistente();
    }

    public static Database getDatabase() { return database; }

    public Persistente getPessoaPersistente() { return pessoaPersistente; }
    public void setPessoaPersistente(Persistente pessoa) { this.pessoaPersistente = pessoa; }

    public Persistente getCarroPersistente() { return carroPersistente; }
    public void setCarroPersistente(Persistente carro) { this.carroPersistente = carro; }

    public Persistente getAluguelPersistente() { return aluguelPersistente; }
    public void setAluguelPersistente(Persistente aluguel) { this.aluguelPersistente = aluguel; }
}
