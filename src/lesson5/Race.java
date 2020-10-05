package lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Race {
    private ArrayList<Stage> stages;
    private boolean haveWinner;
    private Lock lock = new ReentrantLock();

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));

    }

    public void lock() {
        lock.lock();
    }

    public void unlock() {
        lock.unlock();
    }

    public void setHaveWinner(String nameWinner) {
        if (!this.haveWinner) {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Победитель" + nameWinner);
            this.haveWinner = true;
        }

    }
}
