public class TablicaRunnableDisplay implements Runnable {
    private Tablica tablica;
    TablicaRunnableDisplay(Tablica tablica) {
        this.tablica = tablica;
    }
    @Override
    public void run() {
        while (!tablica.IsEnded()) {
            tablica.wyswietl();
            System.out.println();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        tablica.wyswietl();
    }
}
