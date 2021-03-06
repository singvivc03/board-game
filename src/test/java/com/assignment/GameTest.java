package com.assignment;

import com.assignment.model.Board;
import com.assignment.model.CrookedDice;
import com.assignment.model.Dice;
import com.assignment.model.FairDice;
import com.assignment.utils.NumberPicker;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GameTest {

   @Mock
   private NumberPicker numberPicker;

   @CsvSource({
      "100, 3, 3",
      "100, 5, 5",
      "100, 1, 1",
   })
   @ParameterizedTest
   void shouldPlayGameOfSingleMove(final int boardSize, final int moveBy, final int expectedNextPosition) {
      Board board = new Board(boardSize);
      Game game = new Game(board, new FairDice(numberPicker));
      Mockito.when(numberPicker.getNumber()).thenReturn(moveBy);
      int nextPosition = game.play();
      assertEquals(nextPosition, expectedNextPosition);
   }

   @CsvSource({
      "100, 14, 7, 5;4;5, 7",
      "100, 14, 7, 5;4;5;6, 13",
      "100, 14, 7, 1;1;1;1;1;1;1;1;1;1;1;1;1;1, 7",
      "100, 14, 7, 1;1;1;1;1;1;1;1;1;1;1;1;1;1;4, 11"
   })
   @ParameterizedTest
   void shouldPlayGameOfBoardWithSnakes(final int size, final int snakeStartPosition, final int snakeEndPosition,
                                        final String moves, final int expectedFinalPosition) {
      Board board = new Board(size);
      board.addSnake(snakeStartPosition, snakeEndPosition);
      Game game = new Game(board, new FairDice(numberPicker));
      Arrays.stream(moves.split(";")).map(Integer::parseInt).forEach(move -> {
         Mockito.when(numberPicker.getNumber()).thenReturn(move);
         game.play();
      });
      assertEquals(board.getCurrentCoinPosition(), expectedFinalPosition);
   }

   @CsvSource({
      "100, 4, 4",
      "100, 6, 6",
      "100, 2, 2",
   })
   @ParameterizedTest
   void shouldPlayGameWithCrookedDice(final int boardSize, final int moveBy, final int expectedNextPosition) {
      Board board = new Board(boardSize);
      Game game = new Game(board, new CrookedDice(numberPicker));
      Mockito.when(numberPicker.getCrookedNumber()).thenReturn(moveBy);
      int nextPosition = game.play();
      assertEquals(nextPosition, expectedNextPosition);
   }
}