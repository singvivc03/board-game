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
      System.out.println(number);
      assertTrue(number >= min && number <= max);
   }

   @CsvSource({
      "1, 6",
      "20, 100",
      "15, 30",
      "15, 16"
   })
   @ParameterizedTest
   void shouldAlwaysGenerateEvenNumber(final int min, final int max) {
      NumberPicker numberPicker = new NumberPicker(min, max);
      int number = numberPicker.getCrookedNumber();
      assertTrue(number >= min && number <= max && number % 2 == 0);
   }
}