package numbers;

import java.util.InputMismatchException;

public class Check {
    static final String[] propertiesArr = {"BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY",
            "JUMPING", "EVEN", "ODD"};
    static final int propertiesLength = propertiesArr.length;

    static boolean numbers(String[] arr) {
        int i = 0;
        long check;
        try {
            for (; i < arr.length && i < 2; i++) {
                check = Long.parseLong(arr[i]);
                if (check < 0) {
                    if (i == 0) {
                        Errors.wrongFirstParam();
                    } else {
                        Errors.wrongSecParam();
                    }
                    return false;
                }
            }
        } catch (InputMismatchException | NumberFormatException e) {
            if (i == 0) {
                Errors.wrongFirstParam();
            } else {
                Errors.wrongSecParam();
            }
            return false;
        }
        return true;
    }

    private static boolean badProperties(String inp) {
        for (String s : propertiesArr) {
            if (inp.equals(s)) {
                return true;
            }
        }
        return false;
    }

    static boolean checkAllProperties(String[] param) {
        int isGood = 0;
        StringBuilder sb = new StringBuilder();
        for (String s : param) {
            if (!badProperties(s)) {
                sb.append(s).append(", ");
                isGood++;
            }
        }
        if (isGood > 0) {
            sb.delete(sb.length() - 2, sb.length());
            if (isGood == 1) {
                Errors.wrongProperty(sb.toString());
            } else {
                Errors.wrongProperties(sb.toString());
            }
            return false;
        }
        return true;
    }

    static int getCountNumbers(String[] params) {
        int count = 0;
        try {
            for (String s : params) {
                Long.parseLong(s);
                ++count;
                if (count == 2) {
                    break;
                }
            }
        } catch (InputMismatchException | NumberFormatException ignored) {
        }
        return count;
    }

}


