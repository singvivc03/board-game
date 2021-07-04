package com.assignment.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberPickerTest {

   @CsvSource({
      "1, 6",
      "20, 100",
      "15, 30",
      "15, 16"
   })
   @ParameterizedTest
   void shouldGenerateNumber(final int min, final int max) {
      NumberPicker numberPicker = new NumberPicker(min, max);
      int number = numberPicker.getNumber();
      assertTrue(number >= min && number <= max);
   }
}