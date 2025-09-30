public class TablicaRunnableInsOne implements Runnable {

    private Tablica tablica;
    TablicaRunnableInsOne(Tablica tablica) {
        this.tablica = tablica;
    }
    @Override
    public void run() {
        for (int i = 0; i < tablica.getTab().length; i++) {
            tablica.wstaw(i, "🔴");
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
