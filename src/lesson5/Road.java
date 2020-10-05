package lesson5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Road extends Stage {

    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}