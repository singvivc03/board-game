package com.assignment;

import com.assignment.model.Board;
import com.assignment.model.Dice;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GameTest {

   @Mock
   private Dice dice;

   @CsvSource({
      "100, 3",
      "100, 5",
      "100, 1",
   })
   @ParameterizedTest
   void shouldPlayGameOfSingleMove(final int boardSize, final int expectedNextPosition) {
      Board board = new Board(boardSize);
      Game game = new Game(board, dice);
      Mockito.when(dice.roll()).thenReturn(expectedNextPosition);
      int nextPosition = game.play();
      assertEquals(nextPosition, expectedNextPosition);
   }
}