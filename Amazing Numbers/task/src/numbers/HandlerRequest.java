package numbers;

public class HandlerRequest {
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

    static String printRequestForOne(long num) {
        StringBuilder sb = new StringBuilder("Properties of ").append(num).append("\n");

        for (int i = 0; i < UserParams.propertiesLength; i++) {
            sb.append(String.format("%12s: %b\n", UserParams.propertiesArr[i].toLowerCase(),
                    HandlerRequest.propertyMode(UserParams.propertiesArr[i], num)));
        }
        return sb.toString();
    }

    static String printRequestForMulti(long num) {
        StringBuilder sb = new StringBuilder(String.format("%20s", num + " is "));

        for (int i = 0; i < UserParams.propertiesLength; i++) {
            if (HandlerRequest.propertyMode(UserParams.propertiesArr[i], num)) {
                sb.append(UserParams.propertiesArr[i].toLowerCase());
                if (!UserParams.propertiesArr[i].equals("EVEN") && !UserParams.propertiesArr[i].equals("ODD")) {
                    sb.append(", ");
                }
            }
        }

        return sb.toString();
    }

    static void handlerRequest(String[] params, int countNumbers, int countParams) {
        if (countNumbers == 1) {
            printRequestForOne(Long.parseLong(params[0]));
        }

    }


}
