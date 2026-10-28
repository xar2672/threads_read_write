package componentes;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<String> words;

    public Database() {
        this.words = new ArrayList<>();
        // TODO: Ler o arquivo "bd.txt" linha por linha e adicionar à lista
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