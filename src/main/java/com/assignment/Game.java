package com.assignment;

import com.assignment.model.Board;
import com.assignment.model.Dice;

public class Game {

   private final Board board;
   private final Dice dice;

   public Game(final Board board, final Dice dice) {
      this.board = board;
      this.dice = dice;
   }

   public int play() {
      int nextPosition = dice.roll();
      int currentPosition = board.updatePosition(nextPosition);
      return currentPosition;
   }
}
