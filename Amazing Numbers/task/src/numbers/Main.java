package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a natural number:");
        int num = sc.nextInt();
        if (num < 1) {
            System.out.println("This number is not natural!");
        } else {
            System.out.printf("Properties of %d\n%12s: %b\n%12s: %b\n%12s: %b\n%12s: %b",
                    num, "even", isEven(num), "odd", !isEven(num), "buzz", iSBuzz(num), "duck", isDuck(num));
        }
    }

    static boolean iSBuzz(int num) {
        return num % 10 == 7 | num % 7 == 0;
    }

    static boolean isEven(int num) {
        return num % 2 == 0;
    }

    static boolean isDuck(int num) {
        return (num + "").contains("0");
    }


    static void Explanation(int num) {
        System.out.print("Explanation\n" + num);
        if (num % 10 == 7 && num % 7 == 0) {
            System.out.println(" is divisible by 7 and ends with 7");
        } else if (num % 10 == 7) {
            System.out.println(" ends with 7");
        } else if (num % 7 == 0) {
            System.out.println(" is divisible by 7");
        } else {
            System.out.println(" is neither divisible by 7 nor does it end with 7");
        }
    }

}