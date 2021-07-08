package com.assignment.model;

public class GreenSnake extends Snake {

   public GreenSnake(int length) {
      super(length);
   }

   @Override
   public boolean bite(int player) {
      return this.players.add(player);
   }

   @Override
   public SnakeType getSnakeType() {
      return SnakeType.Green;
   }
}
