package numbers;

import java.util.Arrays;

class Errors {
    static void goodProperties() {
        System.out.println("Available properties: " + Arrays.toString(Check.propertiesArr) + "\n");
    }

    static void exclusiveProperties(String str) {
        System.out.printf("The request contains mutually exclusive properties: [%s]\n" +
                "There are no numbers with these properties.\n\n", str);
    }

    static void wrongProperty(String prop) {
        System.out.printf("The property [%s] is wrong.\n", prop);
        goodProperties();
    }

    static void wrongProperties(String prop) {
        System.out.printf("The properties [%s] are wrong.\n", prop);
        goodProperties();
    }

    static void wrongFirstParam() {
        System.out.println("The first parameter should be a natural number or zero.\n");
    }

    static void wrongSecParam() {
        System.out.println("The second parameter should be a natural number.\n");
    }

}
