package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {
    public static void main(String[] args) {
        // Setup scanner
        Scanner scanner = new Scanner(System.in);

        // Prompt user for sandwich size (large / small)
        System.out.println("[1] Regular sandwich: $5.45: ");
        System.out.println("[2] Large sandwich: $8.95: ");
        int choice = scanner.nextInt();

        // Prompt user for their age
        System.out.println("Type in your age: ");
        int age = scanner.nextInt();

        // Calculate the discount for the user
        int discount = 0;
        if (age <= 17) {
            // 17 or younger, 10% discount
            discount = 10;
        }else if (age >= 65) {
            // 65 or older, 20% discount
            discount = 20;
        }
    }
}