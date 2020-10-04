package lesson1.fruit;

public class Orange implements Fruit {
    private static final float WEIGHT = 1.5f;

    @Override
    public float getWeight() {
        return WEIGHT;
    }
}
