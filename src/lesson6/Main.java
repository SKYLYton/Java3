package lesson6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] ints = {
                4, 7, 5, 8, 6, 6
        };
        System.out.println(Arrays.toString(getArrayAfterFour(ints)));
    }

    static int[] getArrayAfterFour(int[] ints) throws RuntimeException {
        int lastIndexFour = -1;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 4) {
                lastIndexFour = i + 1;
                break;
            }
        }

        if (lastIndexFour == -1) {
            throw new RuntimeException("The array does not contain 4");
        }

        int[] newInts = new int[ints.length - lastIndexFour];

        if (newInts.length >= 0) {
            System.arraycopy(ints, lastIndexFour, newInts, 0, newInts.length);
        }

        return newInts;
    }
}
