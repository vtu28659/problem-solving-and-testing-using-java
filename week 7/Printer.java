import java.io.*;
import java.util.*;
import java.lang.reflect.Method;

class Printer {
    // Generic method to print array elements of any type T
    public <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}

public class Printer {
    public static void main(String[] args) {
        Printer myPrinter = new Printer();
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};
        
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        
        int count = 0;
        for (Method method : Printer.class.getDeclaredMethods()) {
            if (method.getName().equals("printArray")) {
                count++;
            }
        }
        
        if (count > 1) {
            System.out.println("Method overloading is not allowed!");
        }
    }
}