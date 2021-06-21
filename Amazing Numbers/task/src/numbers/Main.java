package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Welcome to Amazing Numbers!\n\nSupported requests:\n" +
                "- enter a natural number to know its properties;\n- enter 0 to exit.\n");
        long num = 2;
        while (num != 0) {
            System.out.print("\nEnter a request: ");
            num = sc.nextLong();
            System.out.println(num < 0 ? "\nThe first parameter should be a natural number or zero."
                    : num == 0 ? "\nGoodbye!" : "");
            if (num > 0) {
                System.out.printf("Properties of %d\n%12s: %b\n%12s: %b\n%12s: %b\n%12s: %b\n%12s: %b\n", num,
                        "even", isEven(num), "odd", !isEven(num), "buzz", iSBuzz(num), "duck", isDuck(num),
                        "palindromic", isPalindromic(num));
            }
        }
    }

    private static boolean isPalindromic(long num) {
        String s = "" + num;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    static boolean iSBuzz(long num) {
        return num % 10 == 7 | num % 7 == 0;
    }

    static boolean isEven(long num) {
        return num % 2 == 0;
    }

    static boolean isDuck(long num) {
        return Long.toString(num).contains("0");
    }
}