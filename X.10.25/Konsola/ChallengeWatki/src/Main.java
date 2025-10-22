import java.io.IO;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int n = scanner.nextInt();

        Runnable[] runnables = new Runnable[n];
        Thread[] threads = new Thread[n];

        for (int i = 0; i < n; i++) {
            runnables[i] = () -> {
                int priority = random.nextInt(4, 10);
                int threadNumber = random.nextInt(n) % 10;
                int totalnieLosowaLiczbaGoldenRetriverMankun = random.nextInt(10);
                String x = priority + "" + threadNumber + totalnieLosowaLiczbaGoldenRetriverMankun;
                String text = CzyPierwsza(Integer.parseInt(x)) ? "JES" : "NOŁ";
                Thread.currentThread().setPriority(priority);

                System.out.println(x + " " + text);
            };
        }

        for (int i = 0; i < n; i++) {
            threads[i] = new Thread(runnables[i]);
        }
        
        for (var thread : threads) {
            thread.start();
        }
    }
    
    public static boolean CzyPierwsza(int liczba) {
        if (liczba <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(liczba); i++) {
            if (liczba % i == 0) {
                return false;
            }
        }
        return true;
    }
}