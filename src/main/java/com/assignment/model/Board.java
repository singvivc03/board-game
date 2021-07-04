package com.assignment.model;

import com.assignment.exceptions.IllegalMoveException;
import com.assignment.exceptions.IllegalSnakePosition;

import java.util.Arrays;

public class Board {

   private final int[] board;
   private int currentCoinPosition;

   public Board(final int size) {
      if (size <= 0) {
         throw new IllegalArgumentException("board with negative or zero size is not allowed");
      }
      this.board = new int[size];
      Arrays.fill(this.board, -1);
   }

   public Board(final int[] board) {
      this.board = board;
   }

   public int getBoardSize() {
      return this.board.length;
   }

   public int[] getBoard() {
      return this.board;
   }

   public int getCurrentCoinPosition() {
      return this.currentCoinPosition;
   }

   public int updatePosition(final int moveBy) {
      int nextPosition = this.currentCoinPosition + moveBy;
      if (nextPosition > this.board.length) {
         return this.currentCoinPosition;
      }
      if (this.board[nextPosition] >= 0) {
         nextPosition = this.board[nextPosition];
      }
      this.currentCoinPosition = nextPosition;
      return this.currentCoinPosition;
   }

   public void addSnake(final int startPosition, final int endPosition) {
      if (this.board.length <= startPosition || endPosition < 0 || startPosition <= endPosition) {
         throw new IllegalSnakePosition("snake's start position should be greater than the endPosition");
      }
      this.board[startPosition] = endPosition;
   }
}
