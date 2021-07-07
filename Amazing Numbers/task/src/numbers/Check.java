package numbers;

import java.util.InputMismatchException;

public class Check {
    static final String[] propertiesArr = {"BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY",
            "JUMPING", "EVEN", "ODD"};
    static final int propertiesLength = propertiesArr.length;

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

    static int CountNumbersInParams(String[] params) {
        int i = 0;
        try {
            for (String s : params) {
                Long.parseLong(s);
                ++i;
                if (i == 2) {
                    break;
                }
            }
        } catch (InputMismatchException | NumberFormatException ignored) {
        }
        return i;
    }

    static boolean exclusiveProperties(String[] params) {
        int even = 0;
        int odd = 0;
        int duck = 0;
        int spy = 0;
        int sunny = 0;
        int square = 0;
        StringBuilder sb = new StringBuilder();

        for (String e : params) {

            if (e.equals("EVEN") || e.equals("ODD")) {
                even += e.equals("EVEN") && even < 1 ? 1 : 0;
                odd += e.equals("ODD") && odd < 1 ? 1 : 0;
                if (even + odd >= 2) {
                    sb.append("EVEN, ODD");
                    break;
                }
            }

            if (e.equals("DUCK") || e.equals("SPY")) {
                duck += e.equals("DUCK") && duck < 1 ? 1 : 0;
                spy += e.equals("SPY") && spy < 1 ? 1 : 0;
                if (duck + spy >= 2) {
                    sb.append("DUCK, SPY");
                    break;
                }
            }

            if (e.equals("SUNNY") || e.equals("SQUARE")) {
                sunny += e.equals("SUNNY") && sunny < 1 ? 1 : 0;
                square += e.equals("SQUARE") && square < 1 ? 1 : 0;
                if (sunny + square >= 2) {
                    sb.append("SUNNY, SQUARE");
                    break;
                }
            }
        }

        boolean isExc = even + odd >= 2 || duck + spy >= 2 || sunny + square >= 2;

        if (isExc) {
            Errors.exclusiveProperties(sb.toString());
        }
        return isExc;
    }
}


