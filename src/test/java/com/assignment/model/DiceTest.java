package com.assignment.model;

import com.assignment.utils.NumberPicker;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

   @CsvSource({
      "1, 6",
      "20, 100",
      "15, 30",
      "15, 16"
   })
   @ParameterizedTest
   void shouldGenerateNumber(final int min, final int max) {
      NumberPicker numberPicker = new NumberPicker(min, max);
      Dice dice = new FairDice(numberPicker);
      int number = dice.roll();
      assertTrue(number >= min && number <= max);
   }
}