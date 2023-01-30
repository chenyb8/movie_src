package com.jpmc.theater;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;

public class ReservationTests {

  @Test
  void testTotalFee() {
    var customer = new Customer("John Doe", "unused-id");
    var showing = new Showing(
        new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1),
        1,
        LocalDateTime.of(LocalDate.of(2023, 1, 30), LocalTime.of(16, 50))
    );
    assertEquals(28.5, new Reservation(customer, showing, 3).totalFee());
  }

  @Test
  void testSpecialCodeDiscount() {
    var customer = new Customer("John Doe", "unused-id");
    var showing = new Showing(
        new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 10, 1),
        3,
        LocalDateTime.of(LocalDate.of(2023, 1, 30), LocalTime.of(16, 50))
    );
    assertEquals(8.0, new Reservation(customer, showing, 1).totalFee());
  }

  @Test
  void testShowingTimeDiscount() {
    var customer = new Customer("John Doe", "unused-id");
    var showing = new Showing(
        new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 10.0, 0),
        3,
        LocalDateTime.of(LocalDate.of(2023, 1, 30), LocalTime.of(12, 50))
    );
    assertEquals(7.5, new Reservation(customer, showing, 1).totalFee());
  }

  @Test
  void testSequenceDiscount() {
    var customer = new Customer("John Doe", "unused-id");
    var showing = new Showing(
        new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 10.0, 0),
        1,
        LocalDateTime.of(LocalDate.of(2023, 1, 30), LocalTime.of(16, 50))
    );
    assertEquals(7.0, new Reservation(customer, showing, 1).totalFee());
  }

  @Test
  void testDateDiscount() {
    var customer = new Customer("John Doe", "unused-id");
    var showing = new Showing(
        new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 10.0, 0),
        3,
        LocalDateTime.of(LocalDate.of(2023, 1, 7), LocalTime.of(16, 50))
    );
    assertEquals(9, new Reservation(customer, showing, 1).totalFee());
  }
}
