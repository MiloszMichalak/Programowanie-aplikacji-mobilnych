public class Main {
    public static void main(String[] args) throws InterruptedException {
        var szedulec = new Szedulec(5);
        var tasks = szedulec.getTasks();
        szedulec.sortujMalejaco();
        
        for (var task : tasks) {
            var t = new Thread(() -> {
                System.out.println("Thread: " + Thread.currentThread().getName() + " Priorytet: " + task.getPriority() + "\n " + task);
            });
            t.setPriority(task.getPriority());
            t.start();
        }
    }
}