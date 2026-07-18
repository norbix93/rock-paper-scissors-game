package com.norbix.rps.game;

import com.norbix.rps.move.Move;
import com.norbix.rps.player.Player;

import java.util.List;
import java.util.Scanner;

/**
 * Orchestrates the game flow: setup, rounds, and replay.
 */
public class Game {

    private final Judge judge;
    private final Scanner scanner;

    public Game(Judge judge, Scanner scanner) {
        this.judge = judge;
        this.scanner = scanner;
    }

    /**
     * Starts the game loop.
     */
    public void start() {
        System.out.println("Welcome to Rock-Paper-Scissors-Lizard-Spock!");
        System.out.println("Moves: " + Move.asString());
        play();
        System.out.println("See you next time!");
    }

    private void play() {
        boolean playAgain = true;
        while (playAgain) {
            List<Player> players = choosePlayers();
            playOneRound(players.get(0), players.get(1));
            playAgain = wantsToPlayAgain();
        }
    }

    private List<Player> choosePlayers() {
        System.out.println("""
                
                Which mode would you like to play?
                  1. Human vs. Computer
                  2. Computer vs. Computer
                """);
        while (true) {
            String answer = scanner.nextLine().trim();
            switch (answer) {
                case "1" -> { return Player.Factory.humanVsComputer(scanner); }
                case "2" -> { return Player.Factory.computerVsComputer(); }
                default -> System.out.println("Please enter 1 or 2.");
            }
        }
    }

    private void playOneRound(Player player1, Player player2) {
        Move move1 = player1.choose();
        Move move2 = player2.choose();
        System.out.println(player1.getName() + " chooses: " + move1.getName());
        System.out.println(player2.getName() + " chooses: " + move2.getName());
        System.out.println(judge.judge(move1, move2));
    }

    private boolean wantsToPlayAgain() {
        System.out.println("\nDo you want to play again? (yes/no)");
        while (true) {
            String answer = scanner.nextLine().trim();
            if (answer.equalsIgnoreCase("yes")) {
                return true;
            }
            if (answer.equalsIgnoreCase("no")) {
                return false;
            }
            System.out.println("Please answer with yes or no.");
        }
    }
}
