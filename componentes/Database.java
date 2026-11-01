package componentes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<String> words;

    public Database() {
        this.words = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader (new FileReader("bd.txt"))){
            String linha;
            while ((linha = buffer.readLine()) != null ){
                words.add(linha);
            }

        }catch (IOException e){
            throw new RuntimeException ("Erro ao ler a base de dados");
        }
    }

    public String read(int index) {
        return words.get(index);
    }

    public void write(int index) {
        words.set(index, "MODIFICADO");
    }

    public int getSize() {
        return words.size();
    }
}