import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        HomeWork homeWork = new HomeWork();
        // We stated that 4 Threads are ready for use in the system.
        ExecutorService pool = Executors.newFixedThreadPool(4);
        // We used the pool 10000 times.
        for (int i = 0; i < 10000; i++){
            // Execute Threads in the Homework repository.
            pool.execute(homeWork);
        }
    }
}
