package src.Main;

import java.util.Scanner;

public class D2_lab2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter IP address:");

        String ipAddress = scanner.nextLine();

        // Split the IP address
        String[] octets = ipAddress.split("\\.");


        if (octets.length != 4) {
            System.out.println("Error: Invalid IP address format! .");
            return;
        }


        System.out.println("\nThe result is:");
        for (String e : octets) {
            System.out.println(e);
        }
    }
}
