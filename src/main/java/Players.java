import java.util.Arrays;
import java.util.List;

public class Players {

    private static List<Player> playersFirstGameMode = Arrays.asList(new Human(), new Computer());
    private static List<Player> playersSecondGameMode = Arrays.asList(new Computer(), new Computer());

    public static List<Player> getHumanAndComputer() {
        return playersFirstGameMode;
    }
    public static List<Player> getComputerAndComputer() {
        return playersSecondGameMode;
    }
}
