package lesson4;

public class Main {
    private static volatile char c = 'C';
    private static final int COUNT = 30;
    private static Object lock = new Object();

    public static void main(String[] args) {

        thread('A', 'B').start();
        thread('B', 'C').start();
        thread('C', 'A').start();


    }
    static Thread thread(char oldC, char newC){
        return new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                synchronized (lock){
                    while (c != oldC){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(newC);
                    c = newC;
                    lock.notifyAll();
                }
            }
        });
    }
}
