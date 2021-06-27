package numbers;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        welcomeScreen();

        long check = 2;
        while (check != 0) {
            System.out.print("\nEnter a request: ");
            String[] strArr = sc.nextLine().split(" ");
            long[] data = new long[strArr.length];
            try {
                for (int i = 0; i < strArr.length; i++) {
                    data[i] = Long.parseLong(strArr[i]);
                    if (i == 2) {
                        break;
                    }
                }
                check = data[0];

                if (data[0] <= 0) {
                    System.out.println(data[0] == 0 ? "" : "\nThe first parameter should be a natural number or zero.");
                } else {
                    if (data.length == 1) {
                        System.out.println("\n" + requestForOne(check));
                    } else {
                        if (data[1] <= 0) {
                            System.out.println("\nThe second parameter should be a natural number.");
                        } else {
                            for (int i = 0; i < data[1]; i++) {
                                System.out.print("\n" + requestForMulti(data[0] + i));
                            }
                            System.out.println();
                        }
                    }
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("\nThe first parameter should be a natural number or zero.");
            }
        }
        System.out.println("Goodbye!");
    }

    static String requestForOne(long num) {
        return String.format("Properties of %d\n%12s: %b\n%12s: %b\n%12s: %b\n%12s: %b\n%12s: %b\n%12s: %b\n%12s: %b",
                num, "buzz", iSBuzz(num), "duck", isDuck(num), "palindromic", isPalindromic(num), "gapful", isGap(num),
                "spy", isSpy(num), "even", isEven(num), "odd", !isEven(num));
    }

    static String requestForMulti(long num) {
        return String.format("%20s", num + " is ") + (iSBuzz(num) ? "buzz, " : "") + (isDuck(num) ? "duck," : "") +
                (isPalindromic(num) ? "palindromic, " : "") + (isGap(num) ? "gapful, " : "") +
                (isSpy(num) ? "spy, " : "") + (isEven(num) ? "even" : "odd");
    }

    static void welcomeScreen() {
        System.out.println("Welcome to Amazing Numbers!\n" +
                "\n" +
                "Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameters show how many consecutive numbers are to be processed;\n" +
                "- two natural numbers and a property to search for;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");
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

    static boolean isGap(long num) {
        String gap = Long.toString(num);
        int firstLast = Integer.parseInt(gap.charAt(0) + "" + gap.charAt(gap.length() - 1));

        return !(gap.length() < 3 | num % firstLast != 0);
    }

    static boolean isSpy(long num) {
        String[] numCharArr = Long.toString(num).split("");
        long product = 1;
        int sum = 0;
        int dig;
        for (String s : numCharArr) {
            dig = Integer.parseInt(s);
            sum += dig;
            product *= dig;
        }

        return product == sum;
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