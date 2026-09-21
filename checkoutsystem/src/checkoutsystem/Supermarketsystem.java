
package checkoutsystem;

import java.util.Scanner;

public class Supermarketsystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menuOption;

        // DO-WHILE LOOP: Keeps the counter running until the user enters 2 to close
        do {
            System.out.println("\n=== SMART SUPERMARKET CHECKOUT ===");
            System.out.println("1. Start New Customer Checkout");
            System.out.println("2. Close Checkout Counter");
            System.out.print("Select an option (1-2): ");

            // WHILE LOOP: Input validation for menu selection
            while (!scanner.hasNextInt()) {
                System.out.print("Please enter 1 or 2: ");
                scanner.next();
            }
            menuOption = scanner.nextInt();

            // CHECKOUT LOGIC: Runs inside option 1
            if (menuOption == 1) {
                System.out.print("Enter total number of items in cart: ");
                int itemCount = scanner.nextInt();
                double totalBill = 0;

                // FOR LOOP: Iterate through items
                for (int i = 1; i <= itemCount; i++) {
                    double itemPrice;

                    // WHILE LOOP: Input validation for positive item price
                    while (true) {
                        System.out.print("Enter price for item #" + i + " ($): ");
                        itemPrice = scanner.nextDouble();
                        if (itemPrice > 0) {
                            break; // Exit price loop when price is valid
                        }
                        System.out.println("Price must be greater than 0.");
                    }

                    totalBill += itemPrice;
                }

                System.out.print("Is customer a Loyalty Member? (true/false): ");
                boolean isMember = scanner.nextBoolean();

                // TERNARY OPERATORS
                double discountRate = (isMember && totalBill > 100) ? 0.15 : (isMember ? 0.05 : 0.0);
                String membershipStatus = isMember ? "VIP / Member" : "Standard Customer";

                double discountAmount = totalBill * discountRate;
                double finalTotal = totalBill - discountAmount;

                // RECEIPT OUTPUT
                System.out.println("\n---------------- RECEIPT ----------------");
                System.out.println("Customer Type   : " + membershipStatus);
                System.out.printf("Subtotal        : $%.2f\n", totalBill);
                System.out.printf("Discount (%d%%)  : -$%.2f\n", (int)(discountRate * 100), discountAmount);
                System.out.printf("Final Total Due : $%.2f\n", finalTotal);
                System.out.println("-----------------------------------------");

            } else if (menuOption != 2) {
                System.out.println("Invalid option. Please choose 1 or 2.");
            }

        } while (menuOption != 2); // Loop terminates when menuOption is 2

        System.out.println("\nCheckout counter closed. Have a great day!");
        scanner.close();
    } // Closes main method
} // Closes class Supermarketsystem
