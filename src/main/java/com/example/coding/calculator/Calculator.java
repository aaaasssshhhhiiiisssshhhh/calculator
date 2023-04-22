package com.example.coding.calculator;

public class Calculator {
    private static Calculator instance;
    private int value;

    private Calculator() {
        value = 0;
    }

    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    //add
    public void add(int number) {
        value += number;
    }

    //divide
    public void divide(int number) {
        if (number != 0) {
            value /= number;
        }
    }

    //subtract
    public void subtract(int number) {
        value -= number;
    }


    //multiply
    public void multiply(int number) {
        value *= number;
    }


    //apply
    public void apply(int number) {
        value = number;
    }

    //currentValue
    public int getValue() {
        return value;
    }
}
