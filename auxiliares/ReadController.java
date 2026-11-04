package auxiliares;
import interfaces.AccessController;

public class ReadController implements AccessController {
    private boolean databaseLock = false; // False para aberta, true para fechada
    private int readerCounter = 0; // Contador para leitores na região crítica

    @Override
    public synchronized void pushReader() throws InterruptedException {
        while (databaseLock) {
            this.wait();
        }
        readerCounter++;
    }

    @Override
    public synchronized void popReader() {
        readerCounter--;
        if(readerCounter == 0) this.notifyAll();
    }

    @Override
    public synchronized void pushWriter() throws InterruptedException {
        while(readerCounter > 0) {
            if()
        }
    }

    @Override
    public synchronized void popWriter() {
        // TODO: Atualizar estado e notificar outras threads
    }
}
