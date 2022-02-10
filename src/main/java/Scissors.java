public class Scissors implements Move {
    @Override
    public String getName() {
        return "scissors";
    }

    @Override
    public boolean defeats(Move move) {
        return "paper".equalsIgnoreCase(move.getName()) || "lizard".equalsIgnoreCase(move.getName());
    }
}
