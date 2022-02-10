package dev.rahwa.service;

import dev.rahwa.model.MontyHall;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MontyHallServiceTest {

    @Test
    public void getRandomNumberBetweenOneAndThreeTest() {

        MontyHallService montyHallService = new MontyHallService();

        for (int i = 0; i < 100; i++) {
            int randomNumber = montyHallService.getRandomNumberBetweenOneAndThree();
            assertTrue(randomNumber <= 3 && randomNumber >= 1 );
        }
    }

    @Test
    public void startGameGuessedNumberGreaterThanLimit() {

        MontyHallService montyHallService = new MontyHallService();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> montyHallService.startGame(4));

        String expectedMessage = "Illegal argument, guessedNumber must be greater than 1 or less than 3: 4";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void startGameGuessedNumberLessThanLimit() {

        MontyHallService montyHallService = new MontyHallService();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> montyHallService.startGame(0));

        String expectedMessage = "Illegal argument, guessedNumber must be greater than 1 or less than 3: 0";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void startGameReturnsAMontyHallGame() {

        MontyHallService montyHallService = new MontyHallService();
        MontyHall game = montyHallService.startGame(2);

        assertNotNull(game);
    }

    @Test
    public void switchBox() {

        MontyHallService montyHallService = new MontyHallService();
        MontyHall game = montyHallService.startGame(2);

        boolean initialGuess = game.isCorrectGuess();

        montyHallService.switchBox(game);

        boolean afterSwitchGuess = game.isCorrectGuess();

        assertNotEquals(initialGuess, afterSwitchGuess);
    }

    @Test
    public void isCorrectGuess() {

        MontyHallService montyHallService = new MontyHallService();
        MontyHall game = montyHallService.startGame(2);

        assertEquals(game.isCorrectGuess(), montyHallService.isCorrectGuess(game));
    }
}
