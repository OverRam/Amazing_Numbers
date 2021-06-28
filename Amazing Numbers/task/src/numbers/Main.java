package numbers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static String[] mode = {"even", "odd", "buzz", "duck", "palindromic", "gapful", "spy"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        welcomeScreen();
        long firstNumber = 1;

        do {
            System.out.print("\nEnter a request: ");
            String[] strArr = sc.nextLine().toLowerCase().split(" ");
            System.out.println();

            if (checkParam(strArr)) {
                firstNumber = Long.parseLong(strArr[0]);

                if (firstNumber != 0) {

                    if (strArr.length == 3) {
                        int findNext = 0;
                        int countNumber = 0;

                        while (findNext < Long.parseLong(strArr[1])) {
                            if (propertyMode(strArr[2], firstNumber + countNumber)) {
                                System.out.println(requestForMulti(firstNumber + countNumber));
                                findNext++;
                            }
                            countNumber++;
                        }

                    } else if (strArr.length == 2) {
                        for (int i = 0; i < Long.parseLong(strArr[1]); i++) {
                            System.out.println(requestForMulti(firstNumber + i));
                        }

                    } else {
                        System.out.println(requestForOne(firstNumber));
                    }
                }
            }
        } while (firstNumber != 0);
        System.out.println("Goodbye!");
    }


    static boolean checkParam(String[] param) {
        try {
            long[] data = new long[param.length];
            for (int i = 0; i < param.length; i++) {
                if (i == 2) {
                    break;
                }
                data[i] = Long.parseLong(param[i]);
            }

            if (data[0] < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
                return false;
            }

            if (data.length > 1 && data[1] <= 0) {
                System.out.println("The second parameter should be a natural number.");
                return false;
            }

            if (param.length > 2) {
                for (String s : mode) {
                    if (s.toLowerCase().equals(param[2])) {
                        return true;
                    }
                }
                System.out.println("The property [" + param[2].toUpperCase() + "] is wrong.\n" +
                        "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY]");
                return false;
            }

        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("The first parameter should be a natural number or zero.");
            return false;
        }
        return true;
    }

    static String requestForOne(long num) {
        return String.format("Properties of %d\n%12s: %b\n%12s: %b\n%12s: %b\n%12s: %b\n%12s: %b\n%12s: %b\n%12s: %b",
                num, "buzz", iSBuzz(num), "duck", isDuck(num), "palindromic", isPalindromic(num), "gapful", isGap(num),
                "spy", isSpy(num), "even", isEven(num), "odd", !isEven(num));
    }

    static String requestForMulti(long num) {
        return String.format("%20s", num + " is ") + (iSBuzz(num) ? "buzz, " : "") + (isDuck(num) ? "duck, " : "") +
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

    static boolean propertyMode(String mode, long num) {
        switch (mode) {
            case "spy":
                return isSpy(num);
            case "buzz":
                return iSBuzz(num);
            case "duck":
                return isDuck(num);
            case "even":
                return isEven(num);
            case "odd":
                return !isEven(num);
            case "palindromic":
                return isPalindromic(num);
            case "gapful":
                return isGap(num);
            default:
                return false;
        }
    }
}