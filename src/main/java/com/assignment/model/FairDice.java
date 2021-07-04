package com.assignment.model;

import com.assignment.utils.NumberPicker;

public class FairDice extends Dice {

   public FairDice(NumberPicker numberPicker) {
      super(numberPicker);
   }

   @Override
   public int roll() {
      return numberPicker.getNumber();
   }
}
