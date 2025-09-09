import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Zadania.hello();
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj liczbę: ");
        int liczba = sc.nextInt();
        Zadania.dzielniki(liczba);

        Random random = new Random();
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = random.nextInt(liczba);
        }
        Zadania.babelek(arr);
    }
}