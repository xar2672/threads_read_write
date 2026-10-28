package interfaces;

public interface AccessController {
    void pushReader() throws InterruptedException;
    void popReader();
    void pushWriter() throws InterruptedException;
    void popWriter();
}
