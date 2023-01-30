package com.jpmc.theater;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class LocalDateProviderTests {

  @Test
  void makeSureCurrentTime() {
    assertNotNull(LocalDateProvider.singleton());
    assertNotNull(LocalDateProvider.singleton().currentDate());
    System.out.println("current time is - " + LocalDateProvider.singleton().currentDate());
  }
}
