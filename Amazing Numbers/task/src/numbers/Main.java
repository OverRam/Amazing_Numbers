package numbers;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        welcomeScreen();
        String[] inpArr;
        int countNumbers;
        int countParam;
        boolean propertyIsAvailable;
        boolean isNotExclusive;
        long[] numbers = {1};

        do {
            System.out.print("Enter a request: ");
            inpArr = sc.nextLine().toUpperCase().trim().split(" ");
            System.out.println();

            String[] properties = {};
            countNumbers = Check.CountNumbersInParams(inpArr);
            countParam = inpArr.length - countNumbers;
            propertyIsAvailable = true;
            isNotExclusive = true;

            if (countParam > 0 && countNumbers > 0) {
                properties = Arrays.copyOfRange(inpArr, countNumbers, inpArr.length);
                propertyIsAvailable = Check.checkAllProperties(properties);
                isNotExclusive = !Check.exclusiveProperties(properties);
            }

            if (propertyIsAvailable && isNotExclusive && Check.numbers(inpArr)) {
                numbers = Check.getNumbers(countNumbers, inpArr);
                if (numbers[0] != 0) {
                    HandlerRequest.print(numbers, properties, countNumbers, countParam);
                }
            }
        } while (numbers[0] != 0);
        System.out.println("Goodbye!");
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
                "- a property preceded by minus must not be present in numbers;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.\n");
    }
}