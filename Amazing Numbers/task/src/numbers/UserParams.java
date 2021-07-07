package numbers;

import java.util.*;

public class UserParams {
    static final String[] propertiesArr = {"BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY",
            "JUMPING", "EVEN", "ODD"};
    static final int propertiesLength = propertiesArr.length;

    private static String[] userProperties;
    private static Long[] numbers;
    private static String[] userInp;

    UserParams() {
        System.out.print("Enter a request: ");
        Scanner sc = new Scanner(System.in);
        userInp = sc.nextLine().toUpperCase().trim().split(" ");
        setNumbersArr();
        setPropertiesArr();

    }

    private void setNumbersArr() {
        LinkedList<Long> listNumbers = new LinkedList<>();
        int i = 0;
        long check;
        try {
            for (; i < userInp.length && i < 2; i++) {
                check = Long.parseLong(userInp[i]);
                if (check < 1) {
                    if (i == 0 && check < 0) {
                        Errors.wrongFirstParam();
                    } else if (i == 1) {
                        Errors.wrongSecParam();
                    }
                    break;
                } else {
                    listNumbers.add(check);
                }
            }
        } catch (InputMismatchException | NumberFormatException e) {
            if (i == 0) {
                Errors.wrongFirstParam();
            } else {
                Errors.wrongSecParam();
            }
        }
        numbers = listNumbers.toArray(new Long[0]);
    }

    private void setPropertiesArr() {
        if (userInp.length > numbers.length) {
            userProperties = Arrays.copyOfRange(userInp, numbers.length, userInp.length);
        }
    }

    static Long[] getNumbers(){
        return numbers;
    }

    static String[] getUserProperties(){
        return userProperties;
    }
}
