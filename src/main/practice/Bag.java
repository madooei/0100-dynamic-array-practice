package practice;

import java.util.Random;

/** A bag of colored balls you draw from at random. */
public class Bag {

  private BallColor[] balls;
  private int size;
  private Random rng;

  public Bag() {
    balls = new BallColor[10];
    size = 0;
    rng = new Random();
  }

  // Assumes ball is not null.
  public void add(BallColor ball) {
    if (size == balls.length) {
      grow();
    }
    balls[size] = ball;
    size++;
  }

  // Draws and removes a ball chosen uniformly at random; order is not
  // preserved, so the gap is filled with the last ball instead of shifting.
  // Throws IllegalStateException if the bag is empty.
  public BallColor remove() {
    if (size == 0) {
      throw new IllegalStateException("the bag is empty");
    }
    int i = rng.nextInt(size);    // pick a slot uniformly at random in [0, size)
    BallColor drawn = balls[i];
    balls[i] = balls[size - 1];   // fill the gap with the last ball
    size--;
    balls[size] = null;           // clear the now-unused slot
    return drawn;
  }

  public int size() {
    return size;
  }

  // Doubles the capacity.
  private void grow() {
    BallColor[] bigger = new BallColor[balls.length * 2];
    for (int i = 0; i < size; i++) {
      bigger[i] = balls[i];
    }
    balls = bigger;
  }
}
