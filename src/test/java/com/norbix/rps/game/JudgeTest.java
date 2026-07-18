package com.norbix.rps.game;

import com.norbix.rps.move.Move;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JudgeTest {

    private Judge judge;

    @BeforeEach
    void setUp() {
        judge = new Judge();
    }

    @ParameterizedTest
    @MethodSource("provideMovesAndResults")
    void judge(Move move1, Move move2, String expectedResult) {
        String actualResult = judge.judge(move1, move2);

        assertNotNull(actualResult);
        assertEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> provideMovesAndResults() {
        return Stream.of(
                // Player 1 wins
                Arguments.of(Move.ROCK,     Move.SCISSORS, "Player 1 wins"),
                Arguments.of(Move.SPOCK,    Move.SCISSORS, "Player 1 wins"),
                Arguments.of(Move.SPOCK,    Move.ROCK,     "Player 1 wins"),
                Arguments.of(Move.LIZARD,   Move.PAPER,    "Player 1 wins"),
                Arguments.of(Move.SCISSORS, Move.PAPER,    "Player 1 wins"),
                Arguments.of(Move.PAPER,    Move.ROCK,     "Player 1 wins"),
                Arguments.of(Move.LIZARD,   Move.SPOCK,    "Player 1 wins"),
                Arguments.of(Move.PAPER,    Move.SPOCK,    "Player 1 wins"),
                Arguments.of(Move.ROCK,     Move.LIZARD,   "Player 1 wins"),
                Arguments.of(Move.SCISSORS, Move.LIZARD,   "Player 1 wins"),
                // Player 2 wins
                Arguments.of(Move.ROCK,     Move.PAPER,    "Player 2 wins"),
                Arguments.of(Move.PAPER,    Move.SCISSORS, "Player 2 wins"),
                Arguments.of(Move.LIZARD,   Move.ROCK,     "Player 2 wins"),
                Arguments.of(Move.LIZARD,   Move.SCISSORS, "Player 2 wins"),
                Arguments.of(Move.SPOCK,    Move.PAPER,    "Player 2 wins"),
                Arguments.of(Move.SPOCK,    Move.LIZARD,   "Player 2 wins"),
                // Draws
                Arguments.of(Move.ROCK,     Move.ROCK,     "Nobody wins"),
                Arguments.of(Move.PAPER,    Move.PAPER,    "Nobody wins"),
                Arguments.of(Move.SCISSORS, Move.SCISSORS, "Nobody wins"),
                Arguments.of(Move.LIZARD,   Move.LIZARD,   "Nobody wins"),
                Arguments.of(Move.SPOCK,    Move.SPOCK,    "Nobody wins")
        );
    }
}
