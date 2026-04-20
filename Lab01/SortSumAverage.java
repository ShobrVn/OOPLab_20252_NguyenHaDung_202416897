// Lab 01
// Assignment 6.5

import java.util.Arrays;
import java.util.Scanner;

public class SortSumAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = scanner.nextInt();
        while (n <= 0) {
            System.out.print("Size of array must be positive. Enter again: ");
            n = scanner.nextInt();
        }

        double[] numbers = new double[n];
        System.out.print("Enter array: ");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextDouble();
        }

        Arrays.sort(numbers);

        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += numbers[i];
        }

        double average = sum / n;

        System.out.print("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.printf("%.0f ", numbers[i]);
        }

        System.out.println("\nSum of array elements: " + sum);
        System.out.println("Average value of array elements: " + average);

        scanner.close();
    }
}
