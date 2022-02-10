import java.util.Optional;
import java.util.Scanner;

public class Human implements Player {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Move choose() {
        Optional<Move> move = Optional.empty();
        while (!move.isPresent()) {
            move = ask();
        }
        return move.get();
    }

    private Optional<Move> ask() {
        System.out.println("Please, choose one " + Moves.asString());
        String moveName = scanner.nextLine();
        return Moves.get(moveName);
    }
}
