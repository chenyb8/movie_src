package com.jpmc.theater;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;

public class ShowingTests {

  @Test
  void specialMovieWith50PercentDiscount() {
    Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
    Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.of(2023, 1, 7), LocalTime.of(16, 50)));
    assertEquals(10, showing.calculateTicketPrice());
  }
}
