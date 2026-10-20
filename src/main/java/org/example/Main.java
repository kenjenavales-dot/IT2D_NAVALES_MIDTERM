package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class GymMember {
    private int id;
    private String fullName;
    private String tier;
    private double monthlyFee;
    private String status;

    public GymMember(int id, String fullName, String tier, double monthlyFee, String status) {
        this.id = id;
        this.fullName = fullName;
        this.tier = tier;
        this.monthlyFee = monthlyFee;
        this.status = status;
    }

    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public String getTier() { return tier; }
    public double getMonthlyFee() { return monthlyFee; }
    public String getStatus() { return status; }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<GymMember> members = new ArrayList<>();
        int nextId = 1;
        int choice = 0;

        do {
            System.out.println("--------------------------------------------------");
            System.out.println("             GYM MEMBERSHIP MANAGEMENT            ");
            System.out.println("--------------------------------------------------");
            System.out.println("[1] Add New Member");
            System.out.println("[2] View All Members");
            System.out.println("[3] Exit System");
            System.out.println("--------------------------------------------------");
            System.out.print("Enter choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume leftover newline character
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
                scanner.nextLine(); // Clear invalid token
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("\n--- ADD NEW MEMBER ---");
                    System.out.print("Enter Full Name: ");
                    String fullName = scanner.nextLine();

                    System.out.print("Enter Tier (BASIC / PREMIUM / VIP): ");
                    String tier = scanner.nextLine();

                    System.out.print("Enter Monthly Fee: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Invalid amount. Please enter a valid number for Monthly Fee:");
                        scanner.next();
                    }
                    double monthlyFee = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter Status (ACTIVE / INACTIVE): ");
                    String status = scanner.nextLine();

                    members.add(new GymMember(nextId++, fullName, tier, monthlyFee, status));
                    System.out.println("\nSUCCESS: Member record saved to database!\n");
                    break;

                case 2:
                    System.out.println("\n----------------------------------------------------------------------------------");
                    System.out.println("                                ALL GYM MEMBERS                                   ");
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.printf("| %-3s | %-20s | %-8s | %-12s | %-8s |\n", "ID", "FULL NAME", "TIER", "MONTHLY FEE", "STATUS");
                    System.out.println("----------------------------------------------------------------------------------");

                    for (GymMember m : members) {
                        System.out.printf("| %-3d | %-20s | %-8s | %-12.2f | %-8s |\n",
                                m.getId(),
                                m.getFullName(),
                                m.getTier(),
                                m.getMonthlyFee(),
                                m.getStatus());
                    }

                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println("Total Records Displayed: " + members.size());
                    System.out.println("------------------------------------------------------------------\n");
                    break;

                case 3:
                    System.out.println("\nExiting system... Thank you!");
                    break;

                default:
                    System.out.println("\nInvalid choice! Please select between 1 and 3.\n");
            }

        } while (choice != 3);

        scanner.close();
    }
}