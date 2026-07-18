package com.norbix.rps.game;

import com.norbix.rps.move.Move;

/**
 * Determines the winner of a round given two moves.
 */
public class Judge {

    /**
     * Evaluates the outcome of a round.
     *
     * @param move1 the first player's move
     * @param move2 the second player's move
     * @return the result message, e.g. "Player 1 wins", "Player 2 wins", or "Nobody wins"
     */
    public String judge(Move move1, Move move2) {
        if (move1 == move2) {
            return "Nobody wins";
        }
        if (move1.defeats(move2)) {
            return "Player 1 wins";
        }
        return "Player 2 wins";
    }
}
