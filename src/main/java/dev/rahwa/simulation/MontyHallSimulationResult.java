package dev.rahwa.simulation;

public class MontyHallSimulationResult {

    private final int numberOfRuns;
    private final int countWinNoSwitch;
    private final int countWinWithSwitch;

    public MontyHallSimulationResult(int numberOfRuns, int countWinNoSwitch, int countWinWithSwitch) {
        this.numberOfRuns = numberOfRuns;
        this.countWinNoSwitch = countWinNoSwitch;
        this.countWinWithSwitch = countWinWithSwitch;
    }

    public String toString() {
        return "When game played " + numberOfRuns + " times without switching, number of wins are " + countWinNoSwitch + "\n" +
                "When game played " + numberOfRuns + " times with always switching, number of wins are " + countWinWithSwitch;
    }
}
