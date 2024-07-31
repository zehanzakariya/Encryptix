import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    private static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int roundNumber = 0;

        while (playAgain) {
            roundNumber++;
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("Round " + roundNumber + ": Guess the number between 1 and 100.");

            while (attempts < MAX_ATTEMPTS && !hasGuessedCorrectly) {
                attempts++;
                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                int userGuess = sc.nextInt();

                if (userGuess == numberToGuess) {
                    hasGuessedCorrectly = true;
                    totalScore += (MAX_ATTEMPTS - attempts + 1); // Score based on remaining attempts
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("You've used all " + MAX_ATTEMPTS + " attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play another round? (y/n): ");
            playAgain = sc.next().equalsIgnoreCase("y");
        }

        System.out.println("Game Over! Your total score after " + roundNumber + " rounds is: " + totalScore);
        sc.close();
    }
}
