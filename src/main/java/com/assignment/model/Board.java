package com.assignment.model;

import com.assignment.exceptions.IllegalSnakePosition;

public class Board {

   private final Block[] blocks;
   private int currentCoinPosition;

   public Board(final int size) {
      if (size <= 0) {
         throw new IllegalArgumentException("board with negative or zero size is not allowed");
      }
      this.blocks = new Block[size];
   }

   public Board(final Block[] blocks) {
      this.blocks = blocks;
   }

   public int getBoardSize() {
      return this.blocks.length;
   }

   public Block[] getBoard() {
      return this.blocks;
   }

   public int getCurrentCoinPosition() {
      return this.currentCoinPosition;
   }

   public int updatePosition(final int moveBy, final int player) {
      int nextPosition = this.currentCoinPosition + moveBy;
      if (nextPosition > this.blocks.length) {
         return this.currentCoinPosition;
      }
      if (this.blocks[nextPosition] != null && this.blocks[nextPosition].getPiece() instanceof Snake) {
         Snake snake = (Snake) this.blocks[nextPosition].getPiece();
         if (snake.bite(player)) {
            nextPosition = nextPosition - snake.getLength();
         }
      }
      this.currentCoinPosition = nextPosition;
      return this.currentCoinPosition;
   }

   public void addSnake(final int startPosition, final Snake snake) {
      if (startPosition < 0 || startPosition >= this.blocks.length || startPosition < snake.getLength()) {
         throw new IllegalSnakePosition("start position given is not valid");
      }
      this.blocks[startPosition] = new Block(snake);
   }
}
