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
    balls = new BallColor[10];  // start with room for 10 balls
    size = 0;                   // but the bag starts empty
    rng = new Random();
  }

  public void add(BallColor ball) {
    if (size == balls.length) {
      grow();              // out of room — make the backing array bigger first
    }
    balls[size] = ball;    // drop the ball in the next free slot
    size++;                // one more ball is now in the bag
  }

  public BallColor remove() {
    if (size == 0) {
      throw new IllegalStateException("the bag is empty");
    }
    int i = rng.nextInt(size);    // pick a slot uniformly at random in [0, size)
    BallColor drawn = balls[i];   // this is the ball we hand back
    // The bag promises nothing about order, so we don't shift to close the gap.
    // We drop the last ball into the hole and shrink. That's the whole removal,
    // and it costs the same no matter which slot we drew. (If i is already the
    // last slot, this copies the ball onto itself, which is harmless.)
    balls[i] = balls[size - 1];
    size--;
    balls[size] = null;           // clear the now-unused slot
    return drawn;
  }

  public int size() {
    return size;
  }

  private void grow() {
    BallColor[] bigger = new BallColor[balls.length * 2];
    for (int i = 0; i < size; i++) {
      bigger[i] = balls[i];
    }
    balls = bigger;
  }
}
