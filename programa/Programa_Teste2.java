package programa;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import auxiliares.MutexController;
import componentes.ThreadReader;
import componentes.ThreadWriter;
import componentes.Database;
import interfaces.AccessController;

// BATERIAS DE TESTES COM ACCESS_CONTROLLER => MUTEX_CONTROLLER
public class Programa_Teste2 {
    public static void main(String[] args) throws InterruptedException {
        Database database = new Database();
        double[] medias = new double[101]; 
        
        // TODO: Realizar o loop para as proporções: 
        // 0 Reader/100 Writers até 100 Readers/0 Writers
        
        for (int readers = 0; readers <= 100; readers++) {
            int writers = 100 - readers;
            long soma = 0;
            
            // TODO: Executar as 50 repetições para cada proporção
            for (int i = 0; i < 50; i++) {

                AccessController controller = new MutexController();
                
                List<Thread> threads = new ArrayList<>();
                for (int j = 0; j < readers; j++) threads.add(new ThreadReader(database, controller));
                for (int j = 0; j < writers; j++) threads.add(new ThreadWriter(database, controller));
                
                Collections.shuffle(threads);              // Embaralha o array 
                
                long inicio = System.currentTimeMillis();   // Marca o tempo de início (após os objetos terem sido criados e embaralhados)

                
                for (Thread t : threads) t.start(); // Roda a i-ésima thread
                for (Thread t : threads) t.join();  // Usar join() para a thread principal aguardar o fim de todas as outras
                
                
                // Marca o tempo final
                long fim = System.currentTimeMillis();
                long delta_time = fim - inicio;
                soma += delta_time; // Acumular o tempo para calcular a média no final

            }

            medias[readers] = soma/50.0; // armezena o tempo medio de cada proporção
            
        }

    
    // salva o resultado de cada proporção em uma linha do csv
    try (PrintWriter pw = new PrintWriter(new FileWriter("resultados_mutex.csv"))) {
        pw.println("leitores;escritores;tempo_medio");
        for (int r = 0; r <= 100; r++) {
            pw.println(r + ";" + (100 - r) + ";" + String.format("%.2f", medias[r]).replace('.', ','));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    }
}
