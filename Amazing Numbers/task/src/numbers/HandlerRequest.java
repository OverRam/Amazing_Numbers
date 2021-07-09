package numbers;

public class HandlerRequest {
    static final String[] propertiesArr = {"BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY",
            "JUMPING", "HAPPY", "SAD", "EVEN", "ODD"};
    static final int propertiesLength = propertiesArr.length;

    static boolean propertyMode(String mode, long num) {
        boolean isNeg = mode.charAt(0) == '-';
        mode = isNeg ? mode.replaceFirst("-", "") : mode;

        switch (mode) {
            case "SPY":
                return isNeg != PropertiesNumber.isSpy(num);
            case "BUZZ":
                return isNeg != PropertiesNumber.iSBuzz(num);
            case "DUCK":
                return isNeg != PropertiesNumber.isDuck(num);
            case "EVEN":
                return isNeg != PropertiesNumber.isEven(num);
            case "ODD":
                return isNeg != PropertiesNumber.isOdd(num);
            case "PALINDROMIC":
                return isNeg != PropertiesNumber.isPalindromic(num);
            case "GAPFUL":
                return isNeg != PropertiesNumber.isGap(num);
            case "SQUARE":
                return isNeg != PropertiesNumber.isSquare(num);
            case "SUNNY":
                return isNeg != PropertiesNumber.isSunny(num);
            case "JUMPING":
                return isNeg != PropertiesNumber.isJumping(num);
            case "HAPPY":
                return isNeg != PropertiesNumber.isHappy(num);
            case "SAD":
                return isNeg == PropertiesNumber.isHappy(num);
            default:
                System.out.println("Wrong param(s)" + mode);
                return false;
        }
    }

    static String RequestForOne(long num) {
        StringBuilder sb = new StringBuilder("Properties of ").append(num).append("\n");

        for (int i = 0; i < propertiesLength; i++) {
            sb.append(String.format("%12s: %b\n", propertiesArr[i].toLowerCase(),
                    HandlerRequest.propertyMode(propertiesArr[i], num)));
        }
        return sb.toString();
    }

    static String RequestForMulti(long num) {
        StringBuilder sb = new StringBuilder(String.format("%20s", num + " is "));

        for (int i = 0; i < propertiesLength; i++) {
            if (HandlerRequest.propertyMode(propertiesArr[i], num)) {
                sb.append(propertiesArr[i].toLowerCase());
                if (!propertiesArr[i].equals("EVEN") && !propertiesArr[i].equals("ODD")) {
                    sb.append(", ");
                }
            }
        }

        return sb.toString();
    }

    static void print(long[] numbers, String[] params, int countNumbers, int countParams) {
        if (countNumbers == 1) {
            System.out.println(RequestForOne(numbers[0]));
        } else {
            int findNext = 0;
            int countNumber = 0;
            while (findNext < numbers[1]) {
                if (countParams <= 0) {
                    System.out.println(RequestForMulti(numbers[0] + countNumber));
                    findNext++;
                } else {
                    for (int i = 0; i < countParams; i++) {
                        if (!propertyMode(params[i], numbers[0] + countNumber)) {
                            break;
                        }
                        if (i == countParams - 1) {
                            System.out.println(RequestForMulti(numbers[0] + countNumber));
                            findNext++;
                        }
                    }
                }
                countNumber++;
            }
        }
        System.out.println();
    }
}
