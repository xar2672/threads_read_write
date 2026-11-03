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

            try {
                for (int i=0; i<100; i++){
                    int position = random.nextInt(database.getSize());
                     string word = database.read(position); // Armazena em uma variável local, como pede o enunciado
                }
                    Thread.sleep(1);
            } finally {
                controller.popReader();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }}
