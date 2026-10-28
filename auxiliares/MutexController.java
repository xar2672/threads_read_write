package auxiliares;
import interfaces.AccessController;

public class MutexController implements AccessController {
    private boolean occupied = false;

    @Override
    public synchronized void pushReader() throws InterruptedException {
        // TODO: Bloquear se alguém (qualquer um) já estiver na base
    }

    @Override
    public synchronized void popReader() {
        // TODO: Liberar a base e notificar
    }

    @Override
    public synchronized void pushWriter() throws InterruptedException {
        // TODO: Bloquear se alguém (qualquer um) já estiver na base
    }

    @Override
    public synchronized void popWriter() {
        // TODO: Liberar a base e notificar
    }
}
