package com.assignment.utils;

import java.util.Random;

public class NumberPicker {

   private final Random numberGenerator = new Random();

   private final int min;
   private final int max;

   public NumberPicker(final int min, final int max) {
      this.min = min;
      this.max = max;
   }

   public int getNumber() {
      return numberGenerator.nextInt(max - min + 1) + min;
   }

   public int getCrookedNumber() {
      int min = this.min;
      if (min % 2 != 0) {
         ++min;
      }
      return min + 2 * numberGenerator.nextInt((max - min) / 2 + 1);
   }
}
