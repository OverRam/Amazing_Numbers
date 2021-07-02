package numbers;

public class PropertiesNumber {

    static boolean isJumping(long num) {
        String[] s = Long.toString(num).split("");

        if (s.length == 1) {
            return true;
        }

        int a = Integer.parseInt(s[0]);
        int b;

        for (int i = 1; i < s.length; i++) {
            b = Integer.parseInt(s[i]);
            if (!(a + 1 == b || a - 1 == b)) {
                return false;
            }
        }
        return true;
    }

    static boolean isSunny(long num) {
        double r = Math.sqrt(num + 1);
        return r == (long) r;
    }

    static boolean isSquare(long num) {
        double r = Math.sqrt(num);
        return r == (long) r;
    }

    static boolean isPalindromic(long num) {
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
            case "SPY":
                return PropertiesNumber.isSpy(num);
            case "BUZZ":
                return PropertiesNumber.iSBuzz(num);
            case "DUCK":
                return PropertiesNumber.isDuck(num);
            case "EVEN":
                return PropertiesNumber.isEven(num);
            case "ODD":
                return !PropertiesNumber.isEven(num);
            case "PALINDROMIC":
                return PropertiesNumber.isPalindromic(num);
            case "GAPFUL":
                return PropertiesNumber.isGap(num);
            case "SQUARE":
                return PropertiesNumber.isSquare(num);
            case "SUNNY":
                return PropertiesNumber.isSunny(num);
            case "JUMPING":
                return PropertiesNumber.isJumping(num);
            default:
                System.out.println("Wrong param(s)");
                return false;
        }
    }
}
