package com.assignment.model;

import com.assignment.utils.NumberPicker;

public class Dice {

   private final NumberPicker numberPicker;

   public Dice(final NumberPicker numberPicker) {
      this.numberPicker = numberPicker;
   }

   public int roll() {
      return numberPicker.getNumber();
   }
}
