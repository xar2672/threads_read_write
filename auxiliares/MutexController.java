package auxiliares;
import interfaces.AccessController;

public class MutexController implements AccessController {
    private boolean occupied = false;

    @Override
    public synchronized void pushReader() throws InterruptedException {
        while (occupied == true) {
            this.wait(); // Se ocupado, aguarda
        }
        occupied = true; // Desocupou, entra na zona crítica e fecha
    }

    @Override
    public synchronized void popReader() {
        occupied = false;
        this.notifyAll();
    }

    @Override
    public synchronized void pushWriter() throws InterruptedException {
        while (occupied == true) {
            this.wait(); // Se ocupado, aguarda
        }
        occupied = true; // Desocupou, entra na zona crítica e fecha
    }

    @Override
    public synchronized void popWriter() {
        occupied = false;
        this.notifyAll();
    }
}
