package com.norbix.rps.move;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {

    @Test
    void allReturnsAllFiveMoves() {
        Move[] moves = Move.all();
        assertEquals(5, moves.length);
        assertArrayEquals(new Move[]{Move.ROCK, Move.PAPER, Move.SCISSORS, Move.LIZARD, Move.SPOCK}, moves);
    }

    @Test
    void asStringReturnsCommaSeparatedNames() {
        assertEquals("rock, paper, scissors, lizard, spock", Move.asString());
    }

    @ParameterizedTest
    @MethodSource("provideNamesAndExpectedMoves")
    void fromNameFindsMove(String input, Move expected) {
        Optional<Move> result = Move.fromName(input);
        assertTrue(result.isPresent());
        assertEquals(expected, result.get());
    }

    @Test
    void fromNameReturnsEmptyForInvalidInput() {
        assertTrue(Move.fromName("gun").isEmpty());
        assertTrue(Move.fromName("").isEmpty());
        assertTrue(Move.fromName("   ").isEmpty());
    }

    @Test
    void getNameReturnsLowercase() {
        assertEquals("rock", Move.ROCK.getName());
        assertEquals("spock", Move.SPOCK.getName());
    }

    @ParameterizedTest
    @MethodSource("provideWinningPairs")
    void defeatsReturnsTrueForBeatenMoves(Move attacker, Move victim) {
        assertTrue(attacker.defeats(victim));
    }

    @ParameterizedTest
    @MethodSource("provideLosingPairs")
    void defeatsReturnsFalseForNonBeatenMoves(Move attacker, Move victim) {
        assertFalse(attacker.defeats(victim));
    }

    @Test
    void defeatsReturnsFalseForSameMove() {
        for (Move move : Move.all()) {
            assertFalse(move.defeats(move));
        }
    }

    private static Stream<Arguments> provideNamesAndExpectedMoves() {
        return Stream.of(
                Arguments.of("rock", Move.ROCK),
                Arguments.of("ROCK", Move.ROCK),
                Arguments.of("RoCk", Move.ROCK),
                Arguments.of("spock", Move.SPOCK),
                Arguments.of("lizard", Move.LIZARD)
        );
    }

    private static Stream<Arguments> provideWinningPairs() {
        return Stream.of(
                Arguments.of(Move.ROCK,     Move.SCISSORS),
                Arguments.of(Move.ROCK,     Move.LIZARD),
                Arguments.of(Move.PAPER,    Move.ROCK),
                Arguments.of(Move.PAPER,    Move.SPOCK),
                Arguments.of(Move.SCISSORS, Move.PAPER),
                Arguments.of(Move.SCISSORS, Move.LIZARD),
                Arguments.of(Move.LIZARD,   Move.SPOCK),
                Arguments.of(Move.LIZARD,   Move.PAPER),
                Arguments.of(Move.SPOCK,    Move.SCISSORS),
                Arguments.of(Move.SPOCK,    Move.ROCK)
        );
    }

    private static Stream<Arguments> provideLosingPairs() {
        return Stream.of(
                Arguments.of(Move.ROCK,     Move.PAPER),
                Arguments.of(Move.ROCK,     Move.SPOCK),
                Arguments.of(Move.SCISSORS, Move.ROCK),
                Arguments.of(Move.SCISSORS, Move.SPOCK),
                Arguments.of(Move.PAPER,    Move.SCISSORS),
                Arguments.of(Move.PAPER,    Move.LIZARD),
                Arguments.of(Move.LIZARD,   Move.ROCK),
                Arguments.of(Move.LIZARD,   Move.SCISSORS),
                Arguments.of(Move.SPOCK,    Move.PAPER),
                Arguments.of(Move.SPOCK,    Move.LIZARD)
        );
    }
}
