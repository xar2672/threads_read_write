package auxiliares;
import interfaces.AccessController;

public class ReadController implements AccessController {
    // TODO: Declarar variáveis de controle (ex: contadores de leitores, escritores, condições)

    @Override
    public synchronized void pushReader() throws InterruptedException {
        // TODO: Implementar lógica de espera priorizando leitores
    }

    @Override
    public synchronized void popReader() {
        // TODO: Atualizar estado e notificar outras threads (notifyAll)
    }

    @Override
    public synchronized void pushWriter() throws InterruptedException {
        // TODO: Escritores esperam até que não haja mais leitores na base
    }

    @Override
    public synchronized void popWriter() {
        // TODO: Atualizar estado e notificar outras threads
    }
}
