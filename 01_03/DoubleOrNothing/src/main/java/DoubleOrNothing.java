import java.util.Scanner;
import java.util.Random;

public class DoubleOrNothing {
    // Rule of the game are:
    //  - all players start with a score of 10
    //  - players can decide if they want to double their score
    //  - if they opt the double, then a random test decide if they won or if they loose all
    
    private static int startScore = 10;

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    // initialize to 10
    private int score = startScore;
    private boolean isStillAlive = true;
    private boolean isGameEnded = false;

    public void playGame() {
        this.greetPlayer();
        while (this.isStillAlive && !this.isGameEnded) {
            if (this.ask_for_double_or_end()) {
                this.determine_new_score();
                this.informStatusPlayer();
            }
        }
        if (this.isStillAlive) {
            this.playerEscaped();
        } else {
            this.playerLost();
        }
        
    }

    private void greetPlayer(){
        System.out.println("Hi Player 1 ! You start with " + this.score);
    }

    private void informStatusPlayer(){
        System.out.println("Your current score is: " + this.score);
    }

    private void playerLost(){
        System.out.println("You lose !");
    }

    private void playerEscaped(){
        System.out.println("You exited with a score of: " + this.score + ". Congratulations !");
    }

    private void playerBetChoice(){
        System.out.println("\nDo you want to double your score ? (Y/[N]/END): ");
    }

    private void determine_new_score(){
        double number = this.random.nextDouble();
        this.score *= 2; // Your bet ...
        // Will you keep your bet ?
        if (number >= 0.5) {
            this.score = 0; // GAME OVER !
            this.isStillAlive = false;
        }
    }

    protected boolean ask_for_double_or_end(){
        this.playerBetChoice();
        String userInput = scanner.nextLine().toUpperCase();
        if (userInput.equals("END")) {
            this.isGameEnded = true;
        }

        return userInput.equals("Y");
    }

    protected boolean getIsStillPlaying() {
        return !this.isGameEnded;
    }
}