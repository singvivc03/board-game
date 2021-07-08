package com.assignment.model;

public class Block {

   private final Piece piece;

   public Block(final Piece piece) {
      this.piece = piece;
   }

   public Piece getPiece() {
      return this.piece;
   }
}
