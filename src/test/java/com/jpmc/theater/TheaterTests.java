package com.jpmc.theater;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

public class TheaterTests {

  @Test
  void totalFeeForCustomer() {
    Theater theater = new Theater(LocalDateProvider.singleton());
    Customer john = new Customer("John Doe", "id-12345");
    Reservation reservation = theater.reserve(john, 2, 4);
    assertEquals(37.5, reservation.totalFee());
  }

  @Test
  void printMovieSchedule() throws JsonProcessingException {
    Theater theater = new Theater(LocalDateProvider.singleton());
    assertNotNull(theater);
    theater.printSchedule();
    theater.printScheduleInJson();
  }
}
