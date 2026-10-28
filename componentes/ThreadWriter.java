package componentes;
import java.util.Random;
import interfaces.AccessController;

public class ThreadWriter extends Thread {
    private Database database;
    private AccessController controller;
    private Random random;

    public ThreadWriter(Database database, AccessController controller) {
        this.database = database;
        this.controller = controller;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            controller.pushWriter(); // Entra na Região Crítica Inteira
            
            // TODO: Fazer 100 acessos aleatórios usando database.escrever(index)
            
            Thread.sleep(1); // Simula validação
            
            controller.popWriter(); // Sai da Região Crítica
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}