package com.assignment.model;

import com.assignment.utils.NumberPicker;

public abstract class Dice {

   protected final NumberPicker numberPicker;

   public Dice(final NumberPicker numberPicker) {
      this.numberPicker = numberPicker;
   }

   public abstract int roll();
}
