package com.assignment.model;

import com.assignment.exceptions.IllegalSnakePosition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BoardTest {

   @CsvSource({
      "1, 1",
      "100, 100",
      "1000, 1000"
   })
   @ParameterizedTest
   void shouldCreateBoardOfGivenSize(final int size, final int expectedSize) {
      Board board = new Board(size);
      assertThat(board.getCurrentCoinPosition(), is(0));
      assertThat(board.getBoardSize(), is(expectedSize));
   }

   @CsvSource({
      "0",
      "-1",
   })
   @ParameterizedTest
   void shouldThrowException(final int size) {
      assertThrows(IllegalArgumentException.class, () -> new Board(size));
   }

   @CsvSource({
      "100, 3;2;1;4, 10"
   })
   @ParameterizedTest
   void shouldUpdatePositionOfCoinOnBoard(final int size, final String moveBy, final int expectedPosition) {
      Board board = new Board(size);
      assertThat(board.getCurrentCoinPosition(), is(0));
      Arrays.stream(moveBy.split(";")).map(it -> Integer.parseInt(it))
         .forEach(move -> board.updatePosition(move));
      assertThat(board.getCurrentCoinPosition(), is(expectedPosition));
   }

   @CsvSource({
      "100, 14, 7",
      "10, 9, 1",
      "15, 14, 2",
   })
   @ParameterizedTest
   void shouldAddPositionOfSnakesOnTheBoard(final int boardSize, final int startPosition, final int endPosition) {
      Board board = new Board(boardSize);
      board.addSnake(startPosition, endPosition);
      assertThat(board.getBoard()[startPosition], is(endPosition));
   }

   @CsvSource({
      "100, 101, 90",
      "100, 9, 10",
      "100, 10, -1",
      "100, -1, 1",
      "100, -1, -1",
      "100, 100, 90"
   })
   @ParameterizedTest
   void shouldThrowIllegalSnakePosition(final int boardSize, final int startPosition, final int endPosition) {
      Board board = new Board(boardSize);
      assertThrows(IllegalSnakePosition.class, () -> board.addSnake(startPosition, endPosition));
   }
}