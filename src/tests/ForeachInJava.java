package tests;

import java.util.Arrays;
import java.util.List;

public class ForeachInJava {
    public static int s = 0;
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple","banana","orange","berry");
        
        fruits.forEach(fruit -> System.out.println(fruit) );
        
        fruits.forEach(System.out::println);
        
        fruits.forEach(ForeachInJava::printEntry);
        
        List<Integer> ln = Arrays.asList(12,3,5,7,11);
        ln.forEach(n -> { s+=n ; });
        System.out.println("S = " + s);
    }
    
    public static void printEntry(String f) {
        System.out.println(f);
    }
}
