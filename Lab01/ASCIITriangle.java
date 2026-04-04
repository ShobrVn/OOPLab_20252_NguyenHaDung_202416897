// Lab 01
// Assignment 6.3
import java.util.Scanner;

public class ASCIITriangle {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter the height of the triangle: ");
        int n = keyboard.nextInt();
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++)
                System.out.print(" ");
            for (int j = 1; j <= i*2-1; j++)
                System.out.print("*");

            System.out.println();
        }
    }
}
