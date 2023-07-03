package modelo;

// Classe abstrata Entidade com atributo id.
public abstract class Entidade {
    private int id = 0;
    // private static int cont;

    public Entidade() {
        this.id = this.id++;
    }

    public Entidade(String nome){
        this.id++;
    }

    public int getId() { return this.id; }

    public String toString() {
        return "Entidade{" +
                "id=" + id + 
                '}';
    }
}