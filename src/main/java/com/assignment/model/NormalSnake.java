package com.assignment.model;

public class NormalSnake extends Snake {

   public NormalSnake(int length) {
      super(length);
   }

   @Override
   public SnakeType getSnakeType() {
      return SnakeType.Normal;
   }

   @Override
   public boolean bite(int player) {
      return true;
   }
}
