package com.douglasryoung.ctci.contacts;

import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        PrefixMap tree = new PrefixMap();

        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");

            String op = opContact[0];
            String contact = opContact[1];

            switch (op.toLowerCase()) {
                case "add":
                    tree.insert(contact);
                    break;
                case "find":
                    System.out.println(tree.search(contact));
                    break;
                default:
                    throw new IllegalArgumentException("Command must be 'add' or 'find'");
            }
        }

        scanner.close();
    }
}
