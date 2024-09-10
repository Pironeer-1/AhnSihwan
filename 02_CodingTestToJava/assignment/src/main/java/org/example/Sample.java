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
    public static void main(String[] args) {
        Animal cat = new Animal(3, "Cat");
        cat.displayinfo();
    }
}
