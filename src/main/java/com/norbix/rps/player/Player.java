package com.norbix.rps.player;

import com.norbix.rps.move.Move;

import java.util.List;
import java.util.Scanner;

/**
 * A participant in the game who chooses a move each round.
 */
public interface Player {

    /**
     * Selects a move for the current round.
     *
     * @return the chosen move
     */
    Move choose();

    /**
     * Returns a human-readable name for this player.
     *
     * @return e.g. "Player 1", "Computer"
     */
    String getName();

    /**
     * Factory for creating player pairs in different game modes.
     */
    final class Factory {

        private Factory() {
        }

        /**
         * Creates a human vs. computer match-up.
         *
         * @param scanner the shared input scanner for the human player
         * @return a list of two players: [human, computer]
         */
        public static List<Player> humanVsComputer(Scanner scanner) {
            return List.of(
                    new Human("Player 1", scanner),
                    new Computer("Computer")
            );
        }

        /**
         * Creates a computer vs. computer match-up.
         *
         * @return a list of two players: [Computer 1, Computer 2]
         */
        public static List<Player> computerVsComputer() {
            return List.of(
                    new Computer("Computer 1"),
                    new Computer("Computer 2")
            );
        }
    }
}
