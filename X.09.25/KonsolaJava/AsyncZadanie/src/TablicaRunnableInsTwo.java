public class TablicaRunnableInsTwo implements Runnable {
    private Tablica tablica;
    TablicaRunnableInsTwo(Tablica tablica) {
        this.tablica = tablica;
    }
    @Override
    public void run() {
        for (int i = tablica.getTab().length - 1; i >= 0; i--) {
            tablica.wstaw(i, "🟢");
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
