package persistencia;

public class ObjetoNaoEncontradoException extends RuntimeException {
    public ObjetoNaoEncontradoException(int id) {
        super("O objeto de id = " + id + " não foi encontrado.\n");
    }
}
