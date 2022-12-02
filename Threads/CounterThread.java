package udemy.multithreading;

public class CounterThread extends Thread {
    private int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        int maxValue = 100_000_000;

        for (int i = 0; i < maxValue; i++) {
            count++;
        }
        System.out.println(Thread.currentThread().getName() + " finished. Count is " + count);
    }
}
