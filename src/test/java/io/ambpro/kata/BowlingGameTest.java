package io.ambpro.kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BowlingGameTest {
    private BowlingGame game;

    @BeforeEach
    public void setUp() {
        game = new BowlingGame();
    }

    @Test
    void roll_should_score_zero_when_game_of_0() {
        // Given
        int[] line = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        // / When
        game.roll(line);

        // Then
        Assertions.assertEquals(0, game.score());
    }

    @Test
    void roll_should_score_20_when_game_of_1() {
        // Given
        int[] line = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        // When
        game.roll(line);

        // Then
        Assertions.assertEquals(20, game.score());
    }

    @Test
    void roll_should_score_14_when_spare_then_2_then_miss() {
        // Given
        int[] line = {5, 5, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        // When
        game.roll(line);

        // Then
        Assertions.assertEquals(14, game.score());
    }

    @Test
    void roll_should_score_20_when_strike_and_2_then_3_then_miss() {
        // Given
        int[] line = {10, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        // When
        game.roll(line);

        // Then
        Assertions.assertEquals(20, game.score());
    }

    @Test
    void roll_should_score_150_when_10_pairs_of_5_and_spare() {
        // Given
        int[] line = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};

        // When
        game.roll(line);

        // Then
        Assertions.assertEquals(150, game.score());
    }

    @Test
    void roll_should_score_90_when_10_pairs_of_9_and_miss() {
        // Given
        int[] line = {9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0};

        // When
        game.roll(line);

        // Then
        Assertions.assertEquals(90, game.score());
    }

    @Test
    void roll_should_score_300_when_12_strike() {
        // Given
        int[] line = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        // When
        game.roll(line);

        // Then
        Assertions.assertEquals(300, game.score());
    }
}
