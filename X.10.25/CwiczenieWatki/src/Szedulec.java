import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Szedulec {
    private int n;
    private List<Task> tasks;

    public Szedulec(int n) {
        this.n = n;
        var random = new Random();
        tasks = new ArrayList<>(random.ints(n, 1, 10)
                .mapToObj(i -> new Task("Priority: " + i, i))
                .toList());
    }

    public void sortujMalejaco() {
        for (int i = 0; i < tasks.size() - 1; i++) {
            for (int j = 0; j < tasks.size() - i - 1; j++) {
                if (tasks.get(j).getPriority() < tasks.get(j + 1).getPriority()) {
                    var temp = tasks.get(j);
                    tasks.set(j, tasks.get(j + 1));
                    tasks.set(j + 1, temp);
                }
            }
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }
}