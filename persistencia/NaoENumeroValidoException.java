package persistencia;

public class NaoENumeroValidoException extends Exception {
    public NaoENumeroValidoException(int num) {
        super(num + " não é um número ou um número válido.\n");
    }
}