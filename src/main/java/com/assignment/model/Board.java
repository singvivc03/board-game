package com.assignment.model;

import com.assignment.exceptions.IllegalMoveException;
import com.assignment.exceptions.IllegalSnakePosition;

public class Board {

   private final int[] board;
   private int currentCoinPosition;

   public Board(final int size) {
      if (size <= 0) {
         throw new IllegalArgumentException("board with negative or zero size is not allowed");
      }
      this.board = new int[size];
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

   public int updatePosition(final int by) {
      if (this.currentCoinPosition + by < 0) {
         throw new IllegalMoveException("illegal move");
      }
      this.currentCoinPosition += by;
      return this.currentCoinPosition;
   }

   public void addSnake(final int startPosition, final int endPosition) {
      if (this.board.length < startPosition || endPosition < 0 || startPosition < endPosition) {
         throw new IllegalSnakePosition("snake's start position should be greater than the endPosition");
      }
      this.board[startPosition - 1] = endPosition - 1;
   }
}
