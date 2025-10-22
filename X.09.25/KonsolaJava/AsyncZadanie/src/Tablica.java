import java.util.Arrays;
import java.util.Objects;

public class Tablica {
    private String[] tab = new String[60];

    public String[] getTab() {
        return tab;
    }
    
    public boolean IsEnded() {
        return Objects.equals(tab[tab.length - 1], "🔴");
    }

    public Tablica() {
        Arrays.fill(tab, "⚪");
    }
    
    public synchronized void wstaw(int index, String value) {
        tab[index] = value;
    }
    
    public synchronized void wyswietl() {
        for (var item : tab) {
            System.out.print(item + " ");
        }
    }
}
