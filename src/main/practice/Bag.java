package practice;

import java.util.Random;

/**
 * A bag of colored balls, backed by a fixed-size array that doubles its capacity
 * when it fills up. A bag is an unordered collection: you add balls and you draw
 * one out at random. Because order carries no meaning, removal does not bother to
 * shift elements over — it fills the gap with the last ball and shrinks.
 */
public class Bag {

  private BallColor[] balls;   // the underlying fixed-size storage
  private int size;            // how many balls are in the bag right now
  private Random rng;          // source of randomness for drawing a ball

  public Bag() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  public void add(BallColor ball) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  public BallColor remove() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  public int size() {
    return size;
  }

  private void grow() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }
}
