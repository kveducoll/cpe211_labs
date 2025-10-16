package cpe211.karl.LAB_1;

import static kvx.jcandy.Std.*;
import static kvx.jcandy.Flavorful.*;
import java.util.*;

// LAB 1
public class LAB_1_REYES {
    private static List<Integer> array;
    private static final int[] TEST_SIZES = {1024, 5120, 10240, 102400}; // Pre defined kay gitapol ko sa input
    private static final int SEARCH_VAL = 694;

    public static void main(String[] args) {

        // Top card
        clear();
        print(flavor(" UM Digos College ", Color.hex("#f7f30cff"), BGColor.hex("#b80000ff"), Style.bold));
        println(flavor(" DTP ", Color.hex("#000000ff"), BGColor.hex("#ffbb00ff"), Style.bold));
        println(flavor("  KAVIYES LABS | KARL  ", Color.hex("#000000ff"), BGColor.hex("#ffffff"), Style.bold));
        newl();
            
        // Simple table header
        println(flavor("Test Results (Worse Case)", Color.cyan, Style.italic));
        println("=" + "=".repeat(50));
        printf("%-12s | %-8s | %-8s | %-8s%n", "Array Size", "Insert", "Search", "Delete");
        println("-" + "-".repeat(50));
        
        for (int size : TEST_SIZES) {
            testOperations(size);
        }
        
        println("=" + "=".repeat(50));
        newl();
        println(Color.yellow + "Searched for: " + SEARCH_VAL + Style.reset);
        newl();
    }
    
    // Runner
    private static void testOperations(int size) {
        // Initialize array with random data
        initializeArray(size);
        
        // Test insert operation
        long insertTime = measureInsert();
        
        // Test search operation
        long searchTime = measureSearch();
        
        // Test delete operation
        long deleteTime = measureDelete();
        
        // Display results in table format
        printf("%-12d | " + Color.green + "%-6d ms" + Style.reset + " | " + 
               Color.blue + "%-6d ms" + Style.reset + " | " + 
               Color.red + "%-6d ms" + Style.reset + "%n", 
               size, insertTime, searchTime, deleteTime);
    }
    
    // Prep: Initialize with randomized Integers
    private static void initializeArray(int size) {
        array = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array.add(random.nextInt(9999));
        }
    }
    
    // Measure Input Time
    private static long measureInsert() {
        long startTime = System.currentTimeMillis();
        
        // Perform multiple inserts to get measurable time
        for (int i = 0; i < 1000; i++) {
            array.add(0, i);
        }
        
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
    
    // Measure Search Time
    private static long measureSearch() {
        long startTime = System.currentTimeMillis();
        
        // Perform multiple searches
        for (int i = 0; i < 1000; i++) {
            array.contains(i % SEARCH_VAL); // Search for various values
        }
        
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
    
    // Measure Delete Time
    private static long measureDelete() {
        long startTime = System.currentTimeMillis();
        
        // Perform multiple deletes
        int deleteCount = Math.min(500, array.size() / 2);
        for (int i = 0; i < deleteCount; i++) {
            if (!array.isEmpty()) {
                array.remove(0);
            }
        }
        
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
