package cpe211.karl.LAB_2;

import static kvx.jcandy.Std.*;
import static kvx.jcandy.Flavorful.*;

// main
public class LAB_2_REYES {
    private static final int[] TEST_INPUTS = {10, 20, 30, 35, 40};

    public static void main(String[] args) {

        clear();
        print(flavor(" UM Digos College ", Color.hex("#f7f30cff"), BGColor.hex("#b80000ff"), Style.bold));
        println(flavor(" DTP ", Color.hex("#000000ff"), BGColor.hex("#ffbb00ff"), Style.bold));
        println(flavor("  KAVIYES LABS | KARL  ", Color.hex("#000000ff"), BGColor.hex("#ffffff"), Style.bold));
        newl();
        
        println(flavor("Execution Time Analysis", Color.cyan, Style.italic));
        println("=" + "=".repeat(80));
        printf("%-10s | %-20s | %-20s | %-20s%n", "Input", "Recursive Time (ms)", "Iterative Time (ms)", "Observation");
        println("-" + "-".repeat(80));
        
        for (int n : TEST_INPUTS) {
            testFibonacci(n);
        }
        
        println("=" + "=".repeat(80));
        newl();
    }
    
    private static void testFibonacci(int n) {

        long recursiveStart = System.nanoTime();
        fibonacciRecursive(n);
        long recursiveEnd = System.nanoTime();
        double recursiveTime = (recursiveEnd - recursiveStart) / 1_000_000.0;
        
        long iterativeStart = System.nanoTime();
        fibonacciIterative(n);
        long iterativeEnd = System.nanoTime();
        double iterativeTime = (iterativeEnd - iterativeStart) / 1_000_000.0;
        
        String observation = getObservation(recursiveTime, iterativeTime);
        
        printf("%-10d | " + Color.red + "%16.6f ms" + Style.reset + " | " + 
               Color.green + "%16.6f ms" + Style.reset + " | %-20s%n", 
               n, recursiveTime, iterativeTime, observation);
    }
    
    private static long fibonacciRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }
    }
    
    private static long fibonacciIterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be non-negative");
        }
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        long prev = 0;
        long curr = 1;
        
        for (int i = 2; i <= n; i++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }
        
        return curr;
    }
    
    private static String getObservation(double recursiveTime, double iterativeTime) {
        double ratio = recursiveTime / iterativeTime;
        
        if (ratio > 100) {
            return "Recursive >> Iterative";
        } else if (ratio > 10) {
            return "Recursive > Iterative";
        } else if (ratio > 2) {
            return "Recursive slightly slower";
        } else {
            return "Similar performance";
        }
    }
}
