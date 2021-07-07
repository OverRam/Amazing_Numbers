package numbers;

public class HandlerRequest {
    static final String[] propertiesArr = {"BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY",
            "JUMPING", "EVEN", "ODD"};
    static final int propertiesLength = propertiesArr.length;

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
