package com.norbix.rps.player;

import com.norbix.rps.move.Move;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @Test
    void chooseReturnsMoveFromAvailableMoves() {
        Computer computer = new Computer("TestBot");
        Move chosen = computer.choose();
        assertNotNull(chosen);
        assertTrue(Set.of(Move.all()).contains(chosen));
    }

    @Test
    void chooseReturnsSpecificMoveWithSeededRandom() {
        Computer computer = new Computer("TestBot", new Random(42));
        Move chosen = computer.choose();
        assertNotNull(chosen);
    }

    @Test
    void chooseProducesAllMovesOverManyIterations() {
        Computer computer = new Computer("TestBot", new Random(123));
        Set<Move> results = Stream.generate(computer::choose)
                .limit(500)
                .collect(Collectors.toSet());
        assertEquals(5, results.size());
    }

    @Test
    void getNameReturnsProvidedName() {
        Computer computer = new Computer("Hal9000");
        assertEquals("Hal9000", computer.getName());
    }
}
