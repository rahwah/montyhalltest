package dev.rahwa.simulation;

public class Main {

    public static void main(String[] args) {

        MontyHallSimulation simulation = new MontyHallSimulation();
        int numberOfRuns = 10000;

        MontyHallSimulationResult result = simulation.runMontyHallSimulation(numberOfRuns);
        System.out.println(result);

    }

}
