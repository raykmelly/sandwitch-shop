package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {
    public static void main(String[] args) {
        // Setup scanner
        Scanner scanner = new Scanner(System.in);

        // Prompt user for sandwich size (large / small)
        System.out.println("[1] Regular sandwich: $5.45: ");
        System.out.println("[2] Large sandwich: $8.95: ");
        int choice1 = scanner.nextInt();

        // Fix the scanner
        scanner.nextLine();

        // Prompt user for sandwich upgrade (loaded: yes or no)
        System.out.println("Would you like your sandwich loaded? (Y/N): ");
        String reply = scanner.nextLine();

        // Prompt the user to see if they want an upgrade to their sandwich
        int choice2 = 0;
        if (reply.equalsIgnoreCase("Y")) {
            // Answer is yes, ask for type of upgrade
            System.out.println("[1] Regular: $1.00: ");
            System.out.println("[2] Large: $1.75: ");
            choice2 = scanner.nextInt();
        } else if (reply.equalsIgnoreCase("N")) {
            // Answer is no, skip
            System.out.println("User did not want the upgrade...");
        } else {
            // Error, unknown input given, retry.
            System.out.println("[Error]: Unknown input, please try again.");
            System.exit(0);
        }

        // Prompt user for their age
        System.out.println("Type in your age: ");
        int age = scanner.nextInt();

        // Close the scanner
        scanner.close();

        // Calculate the discount for the user
        double discount = 0;
        if (age <= 17) {
            // 17 or younger, 10% discount
            discount = 10;
            System.out.println("You got a 10% discount!");
        }else if (age >= 65) {
            // 65 or older, 20% discount
            System.out.println("You got a 20% discount!");
            discount = 20;
        }

        // Calculate the sandwich cost
        double sandwichCost = 0;
        if (choice1 == 1) {
            // Regular sandwich
            sandwichCost = 5.45;
        } else if (choice1 == 2) {
            // Large sandwich
            sandwichCost = 8.95;
        }

        // Add on the extra cost for a loaded sandwich
        if (choice2 == 1) {
            sandwichCost += 1;
        } else if (choice2 == 2) {
            sandwichCost += 1.75;
        }

        // Apply discount
        sandwichCost -= (sandwichCost * discount/100);

        // Display the final total
        System.out.printf("[Total cost]: $%.2f%n",sandwichCost);
    }
}