// Lab 01
// Assignment 6.4

public class DaysInMonths {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int month;
        do {
            System.out.print("Enter month: ");
            month = scanner.nextInt();
            if (month < 1 || month > 12) {
                System.out.println("Invalid month, please enter a value from 1 to 12.");
            }
        } while (month < 1 || month > 12);

        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        int days = 0;

        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31;
                break;
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
                    days = 29;
                else
                    days = 28;
                break;
        }

        System.out.println("Number of days in month " + month + " of year " + year + " is: " + days);
        scanner.close();
    }
}
