import java.util.*;
import java.io.*;

class NumberGame {
    public static void main(String[] args) {
        int attempts = 5;
        boolean retry = true;
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        while (retry) {
            int rand = random.nextInt(100) + 1;  
            System.out.println("Please enter your guess! (Between 1 and 100)");

            boolean guessed = false;

            for (int i = 1; i <= attempts; i++) {
                int guess = sc.nextInt();

                if (guess == rand) {
                    System.out.println("Congratulations! You guessed the correct number: " + guess);
                    guessed = true;
                    break;
                } else if (guess > rand) {
                    System.out.println("Your guess is too high! Please enter a lower value.");
                } else {
                    System.out.println("Your guess is too low! Please enter a higher value.");
                }
            }

            if (!guessed) {
                System.out.println("Sorry, you've used all your attempts! The correct number was: " + rand);
            }

            System.out.println("Do you want to play again? (y/n)");
            String response = sc.next();

            retry = response.equalsIgnoreCase("y");
        }

        System.out.println("Thanks for playing! Goodbye.");
        sc.close();
    }
}
