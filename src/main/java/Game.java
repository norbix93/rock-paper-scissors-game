import java.util.List;
import java.util.Scanner;

public class Game {

    private Judge judge = new Judge();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to " + Moves.asString() + "!");
        play();
        System.out.println("See you!");
    }

    private void play() {
        boolean playAgain = true;
        while (playAgain) {
            List<Player> players = choosePlayers();
            Player player1 = players.get(0);
            Player player2 = players.get(1);
            playOneRound(player1, player2);
            playAgain = wantsToPlayAgain();
        }
    }

    private List<Player> choosePlayers() {
        System.out.println("""
                Which mode would you like to play? Please enter a number from below.
                1. Human vs. Computer
                2. Computer vs. Computer
                """);
        String answer = scanner.nextLine();
        while (!answer.equals("1") && !answer.equals("2")) {
            System.out.println("Please enter a valid number (1 or 2).");
            answer = scanner.nextLine();
        }
        if (answer.equalsIgnoreCase("1")) {
            return Players.getHumanAndComputer();
        } else
            return Players.getComputerAndComputer();
    }

    private void playOneRound(Player player1, Player player2) {
        Move move1 = player1.choose();
        Move move2 = player2.choose();
        System.out.println("Player 1 chooses: " + move1.getName());
        System.out.println("Player 2 chooses: " + move2.getName());
        String winner = judge.judge(move1, move2);
        System.out.println(winner);
    }

    private boolean wantsToPlayAgain() {
        System.out.println("Do you want to play again? (yes, no)");
        String answer = scanner.nextLine();
        while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
            System.out.println("Please answer with yes or no.");
            answer = scanner.nextLine();
        }
        if (answer.equalsIgnoreCase("yes")) {
            return true;
        } else
            return false;
    }
}
