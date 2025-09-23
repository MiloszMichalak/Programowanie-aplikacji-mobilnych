import java.util.ArrayList;
import java.util.Arrays;

public class Sala {
    private String name;
    
    private int[][] seats = new int[5][5];
    public Sala() {
        for (int[] seat : seats) {
            Arrays.fill(seat, 0);
        }
    }

    public Sala(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean validateSeat(int row, int col) {
        return row >= 0 && row < seats.length && col >= 0 && col < seats[0].length;
    }
    
    public boolean reserveSeat(int row, int col) {
        if (!validateSeat(row, col)) {
            return false;
        }
        if (seats[row][col] == 0) {
            seats[row][col] = 1;
            return true;
        }
        return false;
    }
    
    public void cancelReservation(int row, int col){
        if (validateSeat(row, col) && seats[row][col] == 1) {
            seats[row][col] = 0;
        }
    }
    
    public int countAvailableSeats() {
        int count = 0;
        for (int[] row : seats) {
            for (int seat : row) {
                if (seat == 0) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public void displaySeats() {
        for (int[] row : seats) {
            for (int seat : row) {
                System.out.print(seat + " ");
            }
            System.out.println();
        }
    }
}
