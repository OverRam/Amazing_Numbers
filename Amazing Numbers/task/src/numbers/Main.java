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
            System.out.println(num % 2 == 0 ? "This number is Even." : "This number is Odd.");
            System.out.printf("It is %sa Buzz number.\n", isBuzz(num) ? "" : "not ");
            Explanation(num);
        }
    }

    static boolean isBuzz(int num) {
        String s = num + "";
        return s.charAt(s.length() - 1) == '7' | num / 7.0 == (num / 7);
    }

    static void Explanation(int num) {
        String s = num + "";
        System.out.print("Explanation\n" + num);
        if (s.charAt(s.length() - 1) == '7' && num / 7.0 == (num / 7)) {
            System.out.println(" is divisible by 7 and ends with 7");
        } else if (s.charAt(s.length() - 1) == '7') {
            System.out.println(" ends with 7");
        } else if (num / 7.0 == (num / 7)) {
            System.out.println(" is divisible by 7");
        } else {
            System.out.println(" is neither divisible by 7 nor does it end with 7");
        }
    }

}