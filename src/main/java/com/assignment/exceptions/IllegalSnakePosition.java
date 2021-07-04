package com.assignment.exceptions;

public class IllegalSnakePosition extends RuntimeException {

   public IllegalSnakePosition(final String message) {
      super(message);
   }
}
