package lesson1;

import lesson1.fruit.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private List<T> list = new ArrayList<>();

    public float getWeight() {
        return list.size() > 0 ? list.get(0).getWeight() * list.size() : 0f;
    }

    public void addToBox(T t) {
        if (t != null) {
            list.add(t);
        }
    }

    public boolean compare(Box box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.00001;
    }

    public void intersperse(Box<T> box) {
        this.list.addAll(box.list);
        box.list.clear();
    }
}
