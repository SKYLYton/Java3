package lesson1;

import lesson1.fruit.Apple;
import lesson1.fruit.Orange;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] integers = { 1, 2, 3, 4};
        String[] strings = {"11","22","33", "44"};

        System.out.println(Arrays.toString(integers));
        System.out.println(Arrays.toString(strings));

        System.out.println(Arrays.toString(move(integers, 0, 1)));
        System.out.println(Arrays.toString(move(strings, 1, 3)));


        System.out.println(replaceArr(integers));


        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox1 = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        for (int i = 0; i < 6; i++) {
            appleBox.addToBox(new Apple());
        }

        for (int i = 0; i < 4; i++) {
            orangeBox.addToBox(new Orange());
        }

        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());

        System.out.println(appleBox.compare(orangeBox));

        appleBox1.intersperse(appleBox);

        System.out.println(appleBox.getWeight());
        System.out.println(appleBox1.getWeight());

    }

    static <T> T[] move(T[] ts, int i, int j){
        T t1 = ts[i];
        ts[i] = ts[j];
        ts[j] = t1;
        return ts;
    }

    static <T> List<T> replaceArr (T[] ts){
        return Arrays.asList(ts);
    }
}
