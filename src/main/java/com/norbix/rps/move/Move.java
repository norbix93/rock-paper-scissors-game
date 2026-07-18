package com.norbix.rps.move;

import java.util.Arrays;
import java.util.Optional;

/**
 * Represents all possible moves in Rock-Paper-Scissors-Lizard-Spock.
 * <p>
 * Each move knows which moves it defeats, following the classic rules
 * popularized by the TV show <i>The Big Bang Theory</i>.
 * </p>
 *
 * <pre>
 *     Scissors cuts Paper
 *     Paper covers Rock
 *     Rock crushes Lizard
 *     Lizard poisons Spock
 *     Spock smashes Scissors
 *     Scissors decapitates Lizard
 *     Lizard eats Paper
 *     Paper disproves Spock
 *     Spock vaporizes Rock
 *     Rock crushes Scissors
 * </pre>
 */
public enum Move {

    ROCK,
    PAPER,
    SCISSORS,
    LIZARD,
    SPOCK;

    /**
     * Returns all available moves as an array in declaration order.
     *
     * @return an array of all moves
     */
    public static Move[] all() {
        return values();
    }

    /**
     * Returns a comma-separated string of all move names in declaration order.
     *
     * @return e.g. "rock, paper, scissors, lizard, spock"
     */
    public static String asString() {
        return Arrays.stream(values())
                .map(Move::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
    }

    /**
     * Looks up a move by its display name (case-insensitive).
     *
     * @param name the move name to search for
     * @return an Optional containing the matching move, or empty if not found
     */
    public static Optional<Move> fromName(String name) {
        return Arrays.stream(values())
                .filter(m -> m.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    /**
     * Returns the lowercase display name of this move.
     *
     * @return e.g. "rock", "paper", etc.
     */
    public String getName() {
        return name().toLowerCase();
    }

    /**
     * Determines whether this move defeats the given move.
     *
     * @param other the opposing move
     * @return {@code true} if this move defeats the other, {@code false} otherwise
     */
    public boolean defeats(Move other) {
        return switch (this) {
            case ROCK     -> other == SCISSORS || other == LIZARD;
            case PAPER    -> other == ROCK     || other == SPOCK;
            case SCISSORS -> other == PAPER    || other == LIZARD;
            case LIZARD   -> other == SPOCK    || other == PAPER;
            case SPOCK    -> other == SCISSORS || other == ROCK;
        };
    }
}
