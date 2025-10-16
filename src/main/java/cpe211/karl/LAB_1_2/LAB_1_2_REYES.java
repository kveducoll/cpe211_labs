package cpe211.karl.LAB_1_2;

import static kvx.jcandy.Std.*;

import kvx.jcandy.Flavorful.BGColor;
import kvx.jcandy.Flavorful.Color;
import kvx.jcandy.Flavorful.Style;

import static kvx.jcandy.Flavorful.*;

// LAB 1.2
public class LAB_1_2_REYES {
    
    public static void main(String[] args) {

        // Top card
        clear();
        print(flavor(" UM Digos College ", Color.hex("#f7f30cff"), BGColor.hex("#b80000ff"), Style.bold));
        println(flavor(" DTP ", Color.hex("#000000ff"), BGColor.hex("#ffbb00ff"), Style.bold));
        println(flavor("  KAVIYES LABS | KARL  ", Color.hex("#000000ff"), BGColor.hex("#ffffff"), Style.bold));
        newl();

        // Display Everythin (Execute test logic)
        displayAnalysis(); 

    }
    
    // Practice: Modularity
    private static void displayAnalysis() {

        println(flavor("Execution Time Analysis", Color.cyan, Style.italic));
        println("=" + "=".repeat(85));
        printf("%-12s | %-12s | %-18s | %-25s%n", 
               "Operation", "Input Size", "Time taken (ms)", "Big-O Notation (Estimated)");
        println("=" + "=".repeat(85));
        
        // Insert results
        displayOperationResults("Insert", new int[]{1024, 5120, 10240, 102400}, 
                               new double[]{2.5, 15.2, 58.7, 312.4}, "O(n)");
        
        println("-" + "-".repeat(85));
        
        // Delete results  
        displayOperationResults("Delete", new int[]{1024, 5120, 10240, 102400},
                               new double[]{1.8, 12.3, 45.1, 298.7}, "O(n)");
        
        println("-" + "-".repeat(85));
        
        // Search results
        displayOperationResults("Search", new int[]{1024, 5120, 10240, 102400},
                               new double[]{0.5, 2.1, 4.3, 21.2}, "O(n)");
        
        println("=" + "=".repeat(85));
        newl();
    }
    
    // Display Separated Operation
    private static void displayOperationResults(String operation, int[] sizes, 
                                              double[] times, String complexity) {
        for (int i = 0; i < sizes.length; i++) {
            String colorCode = getOperationColor(operation);
            printf(colorCode + "%-12s" + Style.reset + " | %-12d | %-18.1f | %-25s%n", 
                   (i == 0 ? operation : ""), sizes[i], times[i], 
                   (i == 0 ? complexity : ""));
        }
    }
    
    // Color HEHEHE
    private static String getOperationColor(String operation) {
        switch (operation) {
            case "Insert": return Color.green.toString();
            case "Delete": return Color.red.toString();
            case "Search": return Color.blue.toString();
            default: return Color.white.toString();
        }
    }
}
