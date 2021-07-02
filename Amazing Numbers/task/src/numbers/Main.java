package numbers;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        welcomeScreen();
        long firstNumber = 1;
        do {
            System.out.print("Enter a request: ");
            String[] inpArr = sc.nextLine().toUpperCase().split(" ");
            System.out.println();

            String[] params;
            int countNumbers = Check.getCountNumbers(inpArr);
            int countParam = inpArr.length - countNumbers;
            boolean propIsOn = true;

            if (countParam > 0 && countNumbers > 0) {
                params = Arrays.copyOfRange(inpArr, countNumbers, inpArr.length);
                propIsOn = Check.checkAllProperties(params);
            }

            if (Check.numbers(inpArr) && propIsOn) {

                firstNumber = Long.parseLong(inpArr[0]);

                if (firstNumber != 0) {
                    if (inpArr.length == 4) {
                        int findNext = 0;
                        int countNumber = 0;

                        while (findNext < Long.parseLong(inpArr[1])) {
                            if (PropertiesNumber.propertyMode(inpArr[2], firstNumber + countNumber) &&
                                    PropertiesNumber.propertyMode(inpArr[3], firstNumber + countNumber)) {

                                System.out.println(requestForMulti(firstNumber + countNumber));
                                findNext++;
                            }
                            countNumber++;
                        }

                    } else if (countNumbers == 2 && countParam > 0) {
                        int findNext = 0;
                        int countNumber = 0;

                        while (findNext < Long.parseLong(inpArr[1])) {
                            if (PropertiesNumber.propertyMode(inpArr[2], firstNumber + countNumber)) {
                                System.out.println(requestForMulti(firstNumber + countNumber));
                                findNext++;
                            }
                            countNumber++;
                        }
                        System.out.println();

                    } else if (countNumbers == 2) {
                        for (int i = 0; i < Long.parseLong(inpArr[1]); i++) {
                            System.out.println(requestForMulti(firstNumber + i));
                        }
                        System.out.println();

                    } else {
                        System.out.println(requestForOne(firstNumber));
                    }
                }
            }
        } while (firstNumber != 0);
        System.out.println("Goodbye!");
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

    private static String requestForOne(long num) {
        StringBuilder sb = new StringBuilder("Properties of ").append(num).append("\n");

        for (int i = 0; i < Check.propertiesLength; i++) {
            sb.append(String.format("%12s: %b\n", Check.propertiesArr[i].toLowerCase(),
                    PropertiesNumber.propertyMode(Check.propertiesArr[i], num)));
        }
        return sb.toString();
    }

    private static String requestForMulti(long num) {
        StringBuilder sb = new StringBuilder(String.format("%20s", num + " is "));

        for (int i = 0; i < Check.propertiesLength; i++) {
            if (PropertiesNumber.propertyMode(Check.propertiesArr[i], num)) {
                sb.append(Check.propertiesArr[i].toLowerCase());
                if (!Check.propertiesArr[i].equals("EVEN") && !Check.propertiesArr[i].equals("ODD")) {
                    sb.append(", ");
                }
            }
        }

        return sb.toString();
    }

    private static void welcomeScreen() {
        System.out.println("Welcome to Amazing Numbers!\n" +
                "\n" +
                "Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- two natural numbers and properties to search for;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.\n");
    }
}