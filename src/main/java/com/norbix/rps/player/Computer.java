package com.norbix.rps.player;

import com.norbix.rps.move.Move;

import java.util.Random;

/**
 * A player that chooses moves randomly.
 */
public class Computer implements Player {

    private static final Random DEFAULT_RANDOM = new Random();

    private final String name;
    private final Random random;

    public Computer(String name) {
        this(name, DEFAULT_RANDOM);
    }

    /**
     * Creates a computer player with a custom {@link Random} — useful for testing.
     *
     * @param name   the player name
     * @param random the random source for move selection
     */
    public Computer(String name, Random random) {
        this.name = name;
        this.random = random;
    }

    @Override
    public Move choose() {
        Move[] moves = Move.all();
        return moves[random.nextInt(moves.length)];
    }

    @Override
    public String getName() {
        return name;
    }
}
