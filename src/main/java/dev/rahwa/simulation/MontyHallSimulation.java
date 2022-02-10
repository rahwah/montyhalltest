package dev.rahwa.simulation;

import dev.rahwa.model.MontyHall;
import dev.rahwa.service.MontyHallService;

public class MontyHallSimulation {

    MontyHallService montyHallService;

    public MontyHallSimulation(){
        montyHallService = new MontyHallService();
    }

    public MontyHallSimulationResult runMontyHallSimulation(int numberOfRuns) {

        final int countWinNoSwitch = runSimulation(numberOfRuns, false);
        int countWinWithSwitch = runSimulation(numberOfRuns, true);

        return new MontyHallSimulationResult(numberOfRuns, countWinNoSwitch, countWinWithSwitch);

    }

    public int runSimulation(int numberOfRuns, boolean withSwitch) {

        int winCount = 0;

        for (int i = 0; i < numberOfRuns; i++) {

            MontyHall game = montyHallService.startGame(montyHallService.getRandomNumberBetweenOneAndThree());

            if(withSwitch) {
                montyHallService.switchBox(game);
            }

            if (montyHallService.isCorrectGuess(game)) {
                winCount++;
            }
        }

        return winCount;
    }

}
