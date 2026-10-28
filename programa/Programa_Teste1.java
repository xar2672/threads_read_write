package programa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import auxiliares.ReadController;
import componentes.ThreadReader;
import componentes.ThreadWriter;
import componentes.Database;
import interfaces.AccessController;

// BATERIAS DE TESTES COM ACCESS_CONTROLLER => READ_CONTROLLER
public class Programa_Teste1 {
    public static void main(String[] args) throws InterruptedException {
        Database database = new Database();
        
        // TODO: Realizar o loop para as proporções: 
        // 0 Reader/100 Writers até 100 Readers/0 Writers
        
        for (int readers = 0; readers <= 100; readers++) {
            int writers = 100 - readers;
            
            // TODO: Executar as 50 repetições para cada proporção
            for (int i = 0; i < 50; i++) {
                
                AccessController controller = new ReadController();
                
                List<Thread> threads = new ArrayList<>();
                for (int j = 0; j < readers; j++) threads.add(new ThreadReader(database, controller));
                for (int j = 0; j < writers; j++) threads.add(new ThreadWriter(database, controller));
                
                // Embaralha o array para garantir a aleatoriedade
                Collections.shuffle(threads);
                
                // Marca o tempo de início (após os objetos terem sido criados e embaralhados)
                long inicio = System.currentTimeMillis();
                
                // Roda a i-ésima thread
                for (Thread t : threads) {
                    t.start();
                }
                // Usar join() para a thread principal aguardar o fim de todas as outras
                for (Thread t : threads) {
                    t.join();
                }
                
                // Marca o tempo final
                long fim = System.currentTimeMillis();
                long delta_time = fim - inicio;
                
                // TODO: Armazenar/Acumular o tempo para calcular a média no final
            }
            
            // TODO: Imprimir o tempo médio para esta proporção (Leitores x Escritores)
        }
    }
}
