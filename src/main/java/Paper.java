public class Paper implements Move {

    @Override
    public String getName() {
        return "paper";
    }

    @Override
    public boolean defeats(Move move) {
        return "rock".equalsIgnoreCase(move.getName()) || "spock".equalsIgnoreCase(move.getName());
    }
}

