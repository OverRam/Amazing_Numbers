package numbers;

import java.util.InputMismatchException;

public class Check {
    static final String[] propertiesArr = {"BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY",
            "JUMPING", "HAPPY", "SAD", "EVEN", "ODD"};

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
            if (inp.charAt(0) == '-') {
                inp = inp.replaceFirst("-", "");
            }
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
        boolean isExc = false;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; !isExc && i < params.length; i++) {
            String e = params[i];
            for (int j = 0; j < params.length; j++) {
                String s = params[j];
                if (i != j) {
                    //find pattern: x && -x || -x && x  (example even && -even)
                    if (e.equals("EVEN") && s.equals("ODD") || e.equals("-EVEN") && s.equals("-ODD") ||
                            e.equals("HAPPY") && s.equals("SAD") || e.equals("-HAPPY") && s.equals("-SAD") ||
                            (e.contains("DUCK") && s.contains("SPY") || e.contains("SUNNY") && s.contains("SQUARE"))
                                    && !e.contains("-") && !s.contains("-") || (e.equals("-" + s) ||
                            ("-" + e).equals(s))) {
                        isExc = true;
                        sb.append(e).append(", ").append(s);
                        break;
                    }
                }

            }
        }
        if (isExc) {
            Errors.exclusiveProperties(sb.toString());
        }
        return isExc;
    }

    static long[] getNumbers(int countNumbers, String[] params) {
        long[] numbers = new long[countNumbers];
        for (int i = 0; i < countNumbers; i++) {
            numbers[i] = Long.parseLong(params[i]);
        }
        return numbers;
    }
}