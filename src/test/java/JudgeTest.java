import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class JudgeTest {

    private final Judge judge = new Judge();

    @ParameterizedTest
    @MethodSource("provideMovesAndResults")
    public void judge(Move move1, Move move2, String expectedResult) {
        String actualResult = judge.judge(move1, move2);

        Assert.assertNotNull(actualResult);
        Assert.assertEquals(expectedResult,actualResult);
    }

    private static Stream<Arguments> provideMovesAndResults() {
        Rock rock = new Rock();
        Scissors scissors = new Scissors();
        Paper paper = new Paper();
        Lizard lizard = new Lizard();
        Spock spock = new Spock();

        return Stream.of(
                Arguments.of(rock, scissors, "Player 1 wins"),
                Arguments.of(spock, scissors, "Player 1 wins"),
                Arguments.of(spock, rock, "Player 1 wins"),
                Arguments.of(lizard, paper, "Player 1 wins"),
                Arguments.of(rock, paper, "Player 2 wins"),
                Arguments.of(scissors, paper, "Player 1 wins"),
                Arguments.of(paper, scissors, "Player 2 wins"),
                Arguments.of(lizard, rock, "Player 2 wins"),
                Arguments.of(lizard, scissors, "Player 2 wins"),
                Arguments.of(spock, paper, "Player 2 wins"),
                Arguments.of(spock, lizard, "Player 2 wins"),
                Arguments.of(rock, rock, "Nobody wins"),
                Arguments.of(paper, paper, "Nobody wins"),
                Arguments.of(scissors, scissors, "Nobody wins"),
                Arguments.of(lizard, lizard, "Nobody wins"),
                Arguments.of(spock, spock, "Nobody wins"));
    }
}