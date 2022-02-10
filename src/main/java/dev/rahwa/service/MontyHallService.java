package dev.rahwa.service;

import dev.rahwa.model.MontyHall;

import java.util.Random;

public class MontyHallService {

    private final Random random;

    public MontyHallService() {
        random = new Random();
    }

    /**
     * @return an integer between 1 and 3
     */
    public int getRandomNumberBetweenOneAndThree() {
        return random.nextInt(3) + 1;
    }

    /**
     * Starts game by picking a box number between 1 and 3
     * @param boxNumber, integer between 1 and 3
     * @return game, which is started by making this initial guess
     * @throws IllegalArgumentException - if specified guessedNumber is less than 1 or greater than 3
     */
    public MontyHall startGame(int boxNumber) {

        if (boxNumber < 1 || boxNumber > 3) {
             throw new IllegalArgumentException("Illegal argument, guessedNumber must be greater than 1 or less than 3: " + boxNumber);
        }

        int winningBoxNumber = getRandomNumberBetweenOneAndThree();
        boolean correctGuess = winningBoxNumber == boxNumber;

        return new MontyHall(correctGuess);
    }

    /**
     * Switches the guess made
     * @param game, the Monty Hall game on which to switch the guess on
     */
    public void switchBox(MontyHall game) {
        boolean switchedGuess = !game.isCorrectGuess();
        game.setCorrectGuess(switchedGuess);
    }

    /**
     * Checks if guess made is correct.
     * @param game, the Monty Hall game on which to check the guess
     * @return  true if guess is correct, false if guess is incorrect
     */
    public boolean isCorrectGuess(MontyHall game) {
        return game.isCorrectGuess();
    }

}
