import java.util.Random;
import java.util.Scanner;

public class Lab_09_ArrayStuff {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();

        // ===== Task 1 =====
        int[] dataPoints = new int[100];

        // ===== Task 2 =====
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rnd.nextInt(100) + 1;  // 1–100
        }

        // ===== Task 3 =====
        System.out.println("Data Points (1–100):");
        for (int i = 0; i < dataPoints.length; i++) {
            System.out.print(dataPoints[i]);
            if (i < dataPoints.length - 1)
                System.out.print(" | ");
        }
        System.out.println("\n");

        // ===== Task 4 =====
        int sum = 0;
        for (int val : dataPoints) {
            sum += val;
        }
        double avg = (double) sum / dataPoints.length;
        System.out.printf("The sum of all values is: %d%n", sum);
        System.out.printf("The average of the random array dataPoints is: %.2f%n%n", avg);

        // ===== Task 5 =====
        int userVal = getRangedInt(in, "Enter a value between 1 and 100: ", 1, 100);

        // ===== Task 6 =====
        int count = 0;
        for (int val : dataPoints) {
            if (val == userVal) count++;
        }
        System.out.printf("The value %d was found %d times in the array.%n%n", userVal, count);

        // ===== Task 7 =====
        int searchVal = getRangedInt(in, "Enter another value to find (1–100): ", 1, 100);
        int foundIndex = -1;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == searchVal) {
                foundIndex = i;
                break;  // stop searching after first match
            }
        }

        if (foundIndex != -1) {
            System.out.printf("The value %d was found at array index %d.%n%n", searchVal, foundIndex);
        } else {
            System.out.printf("The value %d was not found in the array.%n%n", searchVal);
        }

        // ===== Task 8 =====
        int min = dataPoints[0];
        int max = dataPoints[0];
        for (int val : dataPoints) {
            if (val < min) min = val;
            if (val > max) max = val;
        }
        System.out.printf("The minimum value in the array is: %d%n", min);
        System.out.printf("The maximum value in the array is: %d%n%n", max);

        // ===== Task 9 =====
        System.out.printf("Average of dataPoints (via method): %.2f%n", getAverage(dataPoints));

        in.close();
    }

    // ===== SafeInput-style getRangedInt =====
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int val;
        while (true) {
            System.out.print(prompt);
            if (pipe.hasNextInt()) {
                val = pipe.nextInt();
                pipe.nextLine(); // clear buffer
                if (val >= low && val <= high) {
                    return val;
                } else {
                    System.out.printf("Error: value must be between %d and %d.%n", low, high);
                }
            } else {
                System.out.println("Error: please enter an integer value.");
                pipe.nextLine(); // discard bad input
            }
        }
    }

    // ===== Task 9 static method =====
    public static double getAverage(int values[]) {
        int sum = 0;
        for (int val : values) {
            sum += val;
        }
        return (double) sum / values.length;
    }
}

