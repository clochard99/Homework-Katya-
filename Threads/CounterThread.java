package udemy.multithreading;

import java.util.concurrent.Callable;

public class CounterThread extends Thread implements Callable {
    private int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    public synchronized Object call() throws Exception {
        int maxValue = 100_000_000;

        for (int i = 0; i < maxValue; i++) {
            count++;
        }
        System.out.println(Thread.currentThread().getName() + " finished. Count is " + count);
        return count;
    }
}
