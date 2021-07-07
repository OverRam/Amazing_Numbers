package numbers;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        welcomeScreen();
        long firstNumber = 1;
        String[] inpArr;
        int countNumbers;
        int countParam;
        boolean propIsOn;
        boolean isNotExc;
        long[] numbersInp;

//        do {

        UserParams uP = new UserParams();


//            System.out.print("Enter a request: ");
//            inpArr = sc.nextLine().toUpperCase().split(" ");
//            System.out.println();
//
//            String[] params;
//            countNumbers = Check.CountNumbersInParams(inpArr);
//            countParam = inpArr.length - countNumbers;
//            propIsOn = true;
//            isNotExc = true;
//
//            if (countParam > 0 && countNumbers > 0) {
//                params = Arrays.copyOfRange(inpArr, countNumbers, inpArr.length);
//                propIsOn = Check.checkAllProperties(params);
//                isNotExc = !Check.exclusiveProperties(params);
//            }
//
//            if (propIsOn && isNotExc && Check.numbers(inpArr)) {
//                HandlerRequest.handlerRequest(inpArr, countNumbers, countParam);
//
//
//                firstNumber = Long.parseLong(inpArr[0]);
//
//                if (firstNumber != 0) {
//                    if (inpArr.length == 4) {
//                        int findNext = 0;
//                        int countNumber = 0;
//
//                        while (findNext < Long.parseLong(inpArr[1])) {
//                            if (HandlerRequest.propertyMode(inpArr[2], firstNumber + countNumber) &&
//                                    HandlerRequest.propertyMode(inpArr[3], firstNumber + countNumber)) {
//
//                                System.out.println(HandlerRequest.printRequestForMulti(firstNumber + countNumber));
//                                findNext++;
//                            }
//                            countNumber++;
//                        }
//
//                    } else if (countNumbers == 2 && countParam > 0) {
//                        int findNext = 0;
//                        int countNumber = 0;
//
//                        while (findNext < Long.parseLong(inpArr[1])) {
//                            if (HandlerRequest.propertyMode(inpArr[2], firstNumber + countNumber)) {
//                                System.out.println(HandlerRequest.printRequestForMulti(firstNumber + countNumber));
//                                findNext++;
//                            }
//                            countNumber++;
//                        }
//                        System.out.println();
//
//                    } else if (countNumbers == 2) {
//                        for (int i = 0; i < Long.parseLong(inpArr[1]); i++) {
//                            System.out.println(HandlerRequest.printRequestForMulti(firstNumber + i));
//                        }
//                        System.out.println();
//
//                    } else {
//                        System.out.println(HandlerRequest.printRequestForOne(firstNumber));
//                    }
//                }
//            }
//        } while (firstNumber != 0);
//        System.out.println("Goodbye!");
//    }
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