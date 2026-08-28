package practice;

import java.util.Random;

/** A bag of colored balls you draw from at random. */
public class Bag {

  private BallColor[] balls;
  private int size;
  private Random rng;

  public Bag() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Assumes ball is not null.
  public void add(BallColor ball) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Draws and removes a ball chosen uniformly at random; order is not
  // preserved, so the gap is filled with the last ball instead of shifting.
  // Throws IllegalStateException if the bag is empty.
  public BallColor remove() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  public int size() {
    return size;
  }

  // Doubles the capacity.
  private void grow() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }
}
