package com.assignment.model;

import com.assignment.exceptions.IllegalMoveException;

public class Board {

   private final int size;
   private int currentCoinPosition;

   public Board(final int size) {
      if (size <= 0) {
         throw new IllegalArgumentException("board with negative or zero size is not allowed");
      }
      this.size = size;
   }

   public int getBoardSize() {
      return this.size;
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
}
