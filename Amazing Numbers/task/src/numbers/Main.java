package numbers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static final String[] property = {"even", "odd", "buzz", "duck", "palindromic", "gapful", "spy", "sunny", "square"};

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
                    if (strArr.length == 4) {
                        int findNext = 0;
                        int countNumber = 0;

                        while (findNext < Long.parseLong(strArr[1])) {
                            if (propertyMode(strArr[2], firstNumber + countNumber) &&
                                    propertyMode(strArr[3], firstNumber + countNumber)) {

                                System.out.println(requestForMulti(firstNumber + countNumber));
                                findNext++;
                            }
                            countNumber++;
                        }

                    } else if (strArr.length == 3) {
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


    private static boolean checkParam(String[] param) {
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
                boolean firstParam = checkProperty(param, 2);
                boolean secParam = true;
                StringBuilder sb = new StringBuilder().append(!firstParam ? param[2].toUpperCase() : "");

                if (param.length == 4) {
                    if (!notExclusiveProperties(param[2], param[3])) {
                        System.out.println("The request contains mutually exclusive properties: [" + param[2] + ", " + param[3] +
                                "\nThere are no numbers with these properties.");
                        return false;
                    }
                    secParam = checkProperty(param, 3);
                    sb.append(!firstParam && !secParam ? ", " : "").append(!secParam ? param[3].toUpperCase() : "");
                    if (secParam && firstParam) {
                        return true;
                    }
                } else if (firstParam) {
                    return true;
                }

                System.out.println("The propert" + (!firstParam && !secParam ? "ies" : "y") + " [" + sb + "] "
                        + (!firstParam && !secParam ? "are" : "is") + " wrong.\n" +
                        "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]");
                return false;
            }

        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("The first parameter should be a natural number or zero.");
            return false;
        }
        return true;
    }

    private static boolean notExclusiveProperties(String firstParam, String secParam) {

        if (firstParam.equalsIgnoreCase("even") && secParam.equalsIgnoreCase("odd") ||
                firstParam.equalsIgnoreCase("odd") && secParam.equalsIgnoreCase("even")) {
            return false;
        } else if (firstParam.equalsIgnoreCase("duck") && secParam.equalsIgnoreCase("spy") ||
                firstParam.equalsIgnoreCase("spy") && secParam.equalsIgnoreCase("duck")) {
            return false;
        } else return (!firstParam.equalsIgnoreCase("sunny") || !secParam.equalsIgnoreCase("square")) &&
                (!firstParam.equalsIgnoreCase("square") || !secParam.equalsIgnoreCase("sunny"));
    }

    private static boolean checkProperty(String[] param, int indexProperty) {
        for (String s : property) {
            if (s.toLowerCase().equals(param[indexProperty])) {
                return true;
            }
        }
        return false;
    }

    private static String requestForOne(long num) {
        return String.format("Properties of %d\n%12s: %b\n%12s: %b\n%12s: %b\n%12s: %b\n%12s: %b\n%12s: %b\n%12s: %b" +
                        "\n%12s: %b\n%12s: %b",
                num, "buzz", iSBuzz(num), "duck", isDuck(num), "palindromic", isPalindromic(num), "gapful", isGap(num),
                "spy", isSpy(num), "square", isSquare(num), "sunny", isSunny(num), "even", isEven(num), "odd",
                !isEven(num));
    }

    private static String requestForMulti(long num) {
        return String.format("%20s", num + " is ") + (iSBuzz(num) ? "buzz, " : "") + (isDuck(num) ? "duck, " : "") +
                (isPalindromic(num) ? "palindromic, " : "") + (isGap(num) ? "gapful, " : "") +
                (isSpy(num) ? "spy, " : "") + (isSquare(num) ? "square " : "") + (isSunny(num) ? "sunny " : "")
                + (isEven(num) ? "even" : "odd");
    }

    private static void welcomeScreen() {
        System.out.println("Welcome to Amazing Numbers!\n" +
                "\n" +
                "Supported requests:\n" +
                "- enter a natural number to know its properties; \n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- two natural numbers and a property to search for;\n" +
                "- two natural numbers and two properties to search for;\n" +
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

    private static boolean isGap(long num) {
        String gap = Long.toString(num);
        int firstLast = Integer.parseInt(gap.charAt(0) + "" + gap.charAt(gap.length() - 1));

        return !(gap.length() < 3 | num % firstLast != 0);
    }

    private static boolean isSpy(long num) {
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

    private static boolean iSBuzz(long num) {
        return num % 10 == 7 | num % 7 == 0;
    }

    private static boolean isEven(long num) {
        return num % 2 == 0;
    }

    private static boolean isDuck(long num) {
        return Long.toString(num).contains("0");
    }

    private static boolean propertyMode(String mode, long num) {
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
            case "square":
                return isSquare(num);
            case "sunny":
                return isSunny(num);
            default:
                return false;
        }
    }

    private static boolean isSunny(long num) {
        double r = Math.sqrt(num + 1);
        return r == (long) r;
    }

    private static boolean isSquare(long num) {
        double r = Math.sqrt(num);
        return r == (long) r;
    }
}