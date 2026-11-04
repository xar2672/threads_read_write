package auxiliares;
import interfaces.AccessController;

public class ReadController implements AccessController {
    private boolean databaseLock = false; // True se houver escritor na base, false caso contrário
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
        while(readerCounter > 0 || databaseLock == true) {
            this.wait();
        }

        databaseLock = true;
    }

    @Override
    public synchronized void popWriter() {
        databaseLock = false;
        this.notifyAll();
    }
}
