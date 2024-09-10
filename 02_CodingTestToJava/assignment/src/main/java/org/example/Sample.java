package org.example;

class Animal {
    int age;
    String type;

    public Animal(int age, String type) {
        this.age = age;
        this.type = type;
    }

    public void displayinfo() {
        System.out.println("Animal Type: " + type + ", Age: " + age);
    }
}

public class Sample {
    enum CoffeeType {
        AMERICANO,
        ICE_AMERICANO,
        CAFE_LATTE
    };

    public static void main(String[] args) {
        for (CoffeeType type : CoffeeType.values()) {
            System.out.println(type);
        }

        Animal cat = new Animal(3, "Cat");
        cat.displayinfo();
    }
}
