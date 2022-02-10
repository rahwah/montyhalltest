package dev.rahwa.model;

public class MontyHall {

    private boolean correctGuess;

    public MontyHall(boolean correctGuess) {
        this.correctGuess = correctGuess;
    }

    public boolean isCorrectGuess() {
        return correctGuess;
    }

    public void setCorrectGuess(boolean correctGuess) {
        this.correctGuess = correctGuess;
    }
}
