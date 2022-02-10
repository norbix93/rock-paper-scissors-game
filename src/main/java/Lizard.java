public class Lizard implements Move {

    @Override
    public String getName() {
        return "lizard";
    }

    @Override
    public boolean defeats(Move move) {
        return "spock".equalsIgnoreCase(move.getName()) || "paper".equalsIgnoreCase(move.getName());
    }
}
