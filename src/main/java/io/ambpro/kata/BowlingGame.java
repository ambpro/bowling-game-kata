package io.ambpro.kata;

public class BowlingGame {
    private int roll = 0;

    private int[] line = new int[21];

    public void roll(int... line) {
        for (int pinsDown : line) {
            this.line[roll++] = pinsDown;
        }
    }

    public int score() {
        int score = 0;
        int index = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(line[index])) {
                score += 10 + line[index + 1] + line[index + 2];
                index++;
            } else if (isSpare(index)) {
                score += 10 + line[index + 2];
                index += 2;
            } else {
                score += line[index] + line[index + 1];
                index += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int index) {
        return index == 10;
    }

    private boolean isSpare(int index) {
        return line[index] + line[index + 1] == 10;
    }
}
