import java.util.Scanner;
import java.util.Random;

public class Task1 {

    public static int playGame() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        int attempts = 0;
        boolean guessCorrect = false;
        int userGuess;
        int score = 0;

        System.out.println("I have generated a number beween 1 and 100! Can you guess it??");
        System.out.println("You have 10 attempts"); // number of maximum attempts are taken as 10

        while (attempts < 10) {
            System.out.print("Enter your Guess:");
            userGuess = sc.nextInt();
            sc.nextLine();
            attempts++;

            if (userGuess == randomNumber) {
                guessCorrect = true;
                System.out.println(
                        "CONGRATSSSSSS!!! YOU GUESSED THE NUMBER CORRECTLY IN" + " " + (attempts) + " " + "ATTEMPTS");
                System.out.println("");
                score = (10 - attempts) * 10;
                break;
            } else if (userGuess < randomNumber) {
                System.out.println(
                        "Your guess is Too Low! Try again! You still have" + " " + (10 - attempts) + " "
                                + "attempts left");
            } else {
                System.out.println(
                        "Your guess is Too High! Try again! You still have" + " " + (10 - attempts) + " "
                                + "attempts left");
            }
        }

        if (!guessCorrect) {
            System.out.println("Sorry you have used all your attempts!");
            System.out.println("The number was " + randomNumber);
        }

        return score;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("-------------WELCOME TO THE NUMBER GUESSING GAME--------------");

        while (playAgain) {
            totalScore = playGame();
            System.out.println("YOUR SCORE: " + totalScore);

            String response;
            boolean validResponse = false;

            while (!validResponse) {
                System.out.println("Do you want to play another round? (YES/NO)");

                response = sc.nextLine(); // Get the user response

                if (response.equalsIgnoreCase("yes")) {
                    playAgain = true;
                    validResponse = true;
                } else if (response.equalsIgnoreCase("no")) {
                    playAgain = false;
                    validResponse = true;
                } else {
                    System.out.println("Invalid input! Please enter 'YES' or 'NO'.");
                }
            }
        }

        System.out.println("THANKU FOR PLAYING!!!!!!!");
        sc.close();
    }
}
