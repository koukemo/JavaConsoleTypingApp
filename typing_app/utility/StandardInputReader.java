package typing_app.utility;

import java.util.Scanner;

public class StandardInputReader {
    /**
     * Enter string
     * @param message Text to be displayed when entrying
     * @return String entered
     */
    public static String inputString(String message) {
        System.out.print(message);

        Scanner scanner = new Scanner(System.in);
        String scanString = scanner.next();
        //scanner.close();

        return scanString;
    }

    /**
     * Enter number
     * @param message Text to be displayed when entrying
     * @return Numbers entered
     */
    public static int inputInt(String message) {
        System.out.print(message);

        Scanner scanner = new Scanner(System.in);
        int scanInt = scanner.nextInt();
        //scanner.close();

        return scanInt;
    }
}
