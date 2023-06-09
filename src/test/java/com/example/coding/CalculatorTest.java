package com.example.coding;

import com.example.coding.calculator.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    //injection the calculator class
    private Calculator calculator;

    @BeforeEach
    public void instance() {
        calculator = Calculator.getInstance();
    }

    //checking test cases for each method

    @Test
    public void addition() {
        calculator.apply(5);
        calculator.add(5);
        assertEquals(10, calculator.getValue());
    }

    @Test
    public void subtraction() {
        calculator.apply(10);
        calculator.subtract(5);
        assertEquals(5, calculator.getValue());
    }

    @Test
    public void multiplaction() {
        calculator.apply(2);
        calculator.multiply(5);
        assertEquals(10, calculator.getValue());
    }

    @Test
    public void division() {
        calculator.apply(9);
        calculator.divide(3);
        assertEquals(3, calculator.getValue());
    }

    @Test
    public void checkDivideByZero() {
        calculator.apply(10);
        calculator.divide(0);
        assertEquals(10, calculator.getValue());
    }

    @Test
    public void apply() {
        calculator.apply(100);
        assertEquals(100, calculator.getValue());
    }

    public void operators (Scanner scanner , int expected){
        ArrayList<String> arrayList = new ArrayList();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            arrayList.add(line);
            String[] parts = line.split(" ");
            String operator = parts[0];
            if (operator.equals("apply")) break;

        }
        String lastElemet = arrayList.get(arrayList.size() -1);
        arrayList.add(0 , lastElemet);

        arrayList.remove(arrayList.size()-1);
        for (String line : arrayList){

            String[] parts = line.split(" ");
            String operator = parts[0];
            int number = Integer.parseInt(parts[1]);
            if (operator.equals("add")) {
                calculator.add(number);
            } else if (operator.equals("subtract")) {
                calculator.subtract(number);
            } else if (operator.equals("multiply")) {
                calculator.multiply(number);
            } else if (operator.equals("divide")) {
                calculator.divide(number);
            } else if (operator.equals("apply")) {
                calculator.apply(number);
            }
        }
        System.out.println("+++++++output+++++ ::" +calculator.getValue());
        scanner.close();

        assertEquals(expected, calculator.getValue());
    }

    @Test
    public void getFileInstruction() throws FileNotFoundException {

        //please provide the path for the txt file for me this is the absolute path:
        File file = new File("/Users/aashish/Desktop/job/coding/src/test/java/com/example/coding/instructions.txt");
        Scanner scanner = new Scanner(file);
        operators(scanner, 36);
    }

    @Test
    public void getFileInstruction1() throws FileNotFoundException {

        //please provide the path for the txt file for me this is the absolute path:
        File file = new File("/Users/aashish/Desktop/job/coding/src/test/java/com/example/coding/instruction1.txt");
        Scanner scanner = new Scanner(file);
        operators(scanner, 32);
    }

    @Test
    public void getFileInstruction2() throws FileNotFoundException {

        //please provide the path for the txt file for me this is the absolute path:
        File file = new File("/Users/aashish/Desktop/job/coding/src/test/java/com/example/coding/instruction2.txt");
        Scanner scanner = new Scanner(file);
        operators(scanner, 1);
    }
}


