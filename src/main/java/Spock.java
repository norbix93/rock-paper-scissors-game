public class Spock implements Move {
    @Override
    public String getName() {
        return "spock";
    }

    @Override
    public boolean defeats(Move move) {
        return "scissors".equalsIgnoreCase(move.getName()) || "rock".equalsIgnoreCase(move.getName());
    }
}
