package com.norbix.rps.player;

import com.norbix.rps.move.Move;

import java.util.Scanner;

/**
 * A player that chooses moves via console input.
 */
public class Human implements Player {

    private final String name;
    private final Scanner scanner;

    public Human(String name, Scanner scanner) {
        this.name = name;
        this.scanner = scanner;
    }

    @Override
    public Move choose() {
        while (true) {
            System.out.println("Please choose one: " + Move.asString());
            String input = scanner.nextLine().trim();
            var move = Move.fromName(input);
            if (move.isPresent()) {
                return move.get();
            }
            System.out.println("Invalid move: \"" + input + "\". Please try again.");
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
