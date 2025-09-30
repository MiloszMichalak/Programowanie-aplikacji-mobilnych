import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var tab = new Tablica();
        
        new Thread(() -> {
            new TablicaRunnableDisplay(tab).run();
        }).start();
        
        new Thread(() -> {
            new TablicaRunnableInsOne(tab).run();
        }).start();
        
        new Thread(() -> {
            new TablicaRunnableInsTwo(tab).run();
        }).start();
    }
}