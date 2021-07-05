package com.assignment.model;

import com.assignment.utils.NumberPicker;

public class CrookedDice extends Dice {

   public CrookedDice(NumberPicker numberPicker) {
      super(numberPicker);
   }

   @Override
   public int roll() {
      return numberPicker.getCrookedNumber();
   }
}
