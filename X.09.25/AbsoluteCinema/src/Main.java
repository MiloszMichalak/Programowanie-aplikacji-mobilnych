//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Sala sala = new Sala();
        
        sala.displaySeats();
        
        System.out.println("Available seats: " + sala.countAvailableSeats());
        System.out.println("Reserving seat (2,3): " + sala.reserveSeat(2, 3));
        
        sala.displaySeats();
        
        System.out.println("Available seats: " + sala.countAvailableSeats());
        System.out.println("Cancelling reservation for seat (2,3)");
        
        sala.cancelReservation(2, 3);
        sala.displaySeats();
        
        System.out.println("Available seats: " + sala.countAvailableSeats());
        
        Kino kino = new Kino();
        System.out.println("Liczba wszystkich dostepnych miejsc w kinie: " + kino.countAvailableSeats());
        kino.displayAllSeats();
        
        
    }
}