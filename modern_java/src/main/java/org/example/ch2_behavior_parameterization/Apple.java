package org.example.ch2_behavior_parameterization;

public class Apple {

    private final Color color;

    private final int weight;

    public Apple(Color color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
            "color=" + color +
            ", weight=" + weight +
            '}';
    }
}
