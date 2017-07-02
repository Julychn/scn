package ch06.practice;

/**
 * Created by scn on 2017/7/2.
 * 抽象类车类
 */
public abstract class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract String Start();
    public abstract String Stop();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
