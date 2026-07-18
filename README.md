# Rock Paper Scissors Lizard Spock

A Java CLI implementation of the classic **Rock-Paper-Scissors-Lizard-Spock** game, 
popularized by the TV show *The Big Bang Theory*.

## Features

- **Two game modes**: Human vs. Computer or Computer vs. Computer
- **Five moves**: Rock, Paper, Scissors, Lizard, Spock
- **Clean OOP design** with enum-based moves, dependency injection, and full test coverage
- **Java 17** with text blocks and switch expressions

## Rules

| Move     | Defeats                |
|----------|------------------------|
| Rock     | Scissors, Lizard       |
| Paper    | Rock, Spock            |
| Scissors | Paper, Lizard          |
| Lizard   | Spock, Paper           |
| Spock    | Scissors, Rock         |

## Getting Started

### Prerequisites
- Java 17+
- Maven 3.6+

### Build & Run

```bash
mvn clean compile exec:java -Dexec.mainClass="com.norbix.rps.GameApplication"
```

### Run Tests

```bash
mvn test
```

## Project Structure

```
src/main/java/com/norbix/rps/
├── GameApplication.java      # Entry point
├── game/
│   ├── Game.java             # Game loop & flow control
│   └── Judge.java            # Round winner determination
├── move/
│   └── Move.java             # Enum representing all moves
└── player/
    ├── Player.java           # Player interface + factory
    ├── Human.java            # Console-input player
    └── Computer.java         # Random-move player
```

## Testing

Tests cover all game logic:
- `MoveTest` -- move names, lookup, defeat rules (all 20 pairs)
- `JudgeTest` -- every winning, losing, and draw combination
- `ComputerTest` -- move selection, deterministic with seeded Random

## License

This project is open source and available under the MIT License.
