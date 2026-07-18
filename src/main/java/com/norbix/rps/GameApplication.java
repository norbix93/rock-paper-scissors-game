package com.norbix.rps;

import com.norbix.rps.game.Game;
import com.norbix.rps.game.Judge;

import java.util.Scanner;

/**
 * Application entry point.
 */
public class GameApplication {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Game game = new Game(new Judge(), scanner);
            game.start();
        }
    }
}
