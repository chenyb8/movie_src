package com.jpmc.theater;

import java.time.LocalDateTime;

public class Showing {

  private static int MOVIE_CODE_SPECIAL = 1;
  private Movie movie;
  private int sequenceOfTheDay;
  private LocalDateTime showStartTime;

  public Showing(Movie movie, int sequenceOfTheDay, LocalDateTime showStartTime) {
    this.movie = movie;
    this.sequenceOfTheDay = sequenceOfTheDay;
    this.showStartTime = showStartTime;
  }

  public Movie getMovie() {
    return movie;
  }

  public LocalDateTime getStartTime() {
    return showStartTime;
  }

  public boolean isSequence(int sequence) {
    return this.sequenceOfTheDay == sequence;
  }

  public double getMovieFee() {
    return calculateFee();
  }

  public int getSequenceOfTheDay() {
    return sequenceOfTheDay;
  }

  public double calculateTicketPrice() {
    return movie.getTicketPrice() - getDiscount(getMovie(), getSequenceOfTheDay(), getStartTime());
  }

  private double calculateFee() {
    return calculateTicketPrice();
  }

  private double getDiscount(Movie movie, int showSequence, LocalDateTime startTime) {
    double specialDiscount = 0;
    double sequenceDiscount = 0;
    double showingTimeDiscount = 0;
    double dateDiscount = 0;

    if (MOVIE_CODE_SPECIAL == movie.getSpecialCode()) {
      specialDiscount = movie.getTicketPrice() * 0.2;  // 20% discount for special movie
    }

    if (showSequence == 1) {
      sequenceDiscount = 3; // $3 discount for 1st show
    } else if (showSequence == 2) {
      sequenceDiscount = 2; // $2 discount for 2nd show
    }

    if (startTime.getHour() >= 11 && startTime.getHour() < 16) {
      showingTimeDiscount = movie.getTicketPrice() * 0.25;
    }

    if (startTime.getDayOfMonth() == 7) {
      dateDiscount = 1;
    }

    // biggest discount wins
    return Math.max(specialDiscount,
        Math.max(sequenceDiscount, Math.max(showingTimeDiscount, dateDiscount)));
  }
}
