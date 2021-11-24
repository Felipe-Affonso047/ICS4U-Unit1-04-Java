/*
* The "GuessingGame" program.
*
* @author  Felipe Garcia Affonso
* @version 1.0
* @since   2021-11-23
*/

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
* This is the calculating heating time program.
*/
final class GuessingGame {
    /**
    * Created constants.
    */
    public static final int ONE = 1;
    /**
    * Created constants.
    */
    public static final int SIX = 6;

    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    *
    */
    private GuessingGame() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        try {
            final int randomNum = ThreadLocalRandom.current().nextInt(1, 7);
            // code from https://www.w3schools.com/java/java_user_input.asp
            final Scanner input = new Scanner(System.in);
            // https://www.w3schools.com/java/java_methods_param.asp
            System.out.println(
                "Try to guess a number between 1 and 6!"
            );
            boolean guess = true;
            while (guess) {
                final String numberGuessed = input.nextLine();
                final int inputInt = Integer.parseInt(numberGuessed);
                if (inputInt == randomNum) {
                    System.out.println("\nCongratulations, you guessed right!");
                    guess = false;
                } else if (inputInt > SIX || inputInt < ONE) {
                    System.out.println(
                        "\nPlease,insert an integer between 6 and 1."
                    );
                } else if (inputInt > randomNum) {
                    System.out.println("\nThe number is a little lower.");
                } else if (inputInt < randomNum) {
                    System.out.println("\nThe number is a little higher.");
                } else {
                    System.out.println(
                        "\nPlease inseart an integer between 6 and 1."
                    );
                }
            }
        } catch (java.util.InputMismatchException error) {
            System.out.println("\nThere was an error: " + error);
        }
        System.out.println("\nDone.");
    }
}
