package componentes;
import java.util.Random;
import interfaces.AccessController;

public class ThreadReader extends Thread {
    private Database database;
    private AccessController controller;
    private Random random;

    public ThreadReader(Database database, AccessController controller) {
        this.database = database;
        this.controller = controller;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            controller.pushReader(); // Entra na Região Crítica Inteira
            
            // TODO: Fazer 100 acessos aleatórios usando database.ler(index)
            // (a posição deve vir do gerador de números aleatórios)
            
            Thread.sleep(1); // Simula validação ainda dentro da região crítica
            
            controller.popReader(); // Sai da Região Crítica
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}