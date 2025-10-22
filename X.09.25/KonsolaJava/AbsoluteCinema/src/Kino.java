import java.util.ArrayList;

public class Kino {
    ArrayList<Sala> Sale = new ArrayList<>();
    
    public Kino() {
        Sale.add(new Sala("Narwal"));
        Sale.add(new Sala("Biedronka"));
        Sale.add(new Sala("Koala"));
        Sale.add(new Sala("Surykatka"));
    }
    
    public int countAvailableSeats() {
        int total = 0;
        for (Sala sala : Sale){
            total += sala.countAvailableSeats();
        }
        return total;
    }
    
    public void displayAllSeats() {
        for (Sala sala : Sale) {
            System.out.println(sala.getName());
            sala.displaySeats();
            System.out.println();
        }
    }
}
