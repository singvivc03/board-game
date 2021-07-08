package com.assignment.model;

import com.assignment.exceptions.IllegalSnakePosition;

import java.util.HashSet;
import java.util.Set;

public abstract class Snake implements Piece {

   private final int length;
   protected final Set<Integer> players;

   protected Snake(final int length) {
      if (length < 0) {
         throw new IllegalSnakePosition("incorrect length of the snake");
      }
      this.length = length;
      this.players = new HashSet<>();
   }

   public int getLength() {
      return this.length;
   }

   protected abstract SnakeType getSnakeType();
   protected abstract boolean bite(final int player);
}
