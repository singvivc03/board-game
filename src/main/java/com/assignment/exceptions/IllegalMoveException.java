package com.assignment.exceptions;

public class IllegalMoveException extends RuntimeException {

   public IllegalMoveException(final String errorMessage) {
      super(errorMessage);
   }
}
