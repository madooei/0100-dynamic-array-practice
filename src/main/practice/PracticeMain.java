package practice;

/**
 * Treats the bag as an urn full of colored balls and draws from it many times to
 * watch a probability take shape. We fill the bag with a known mix, then draw a
 * ball, note its color, and put a ball of the same color back. Because the mix
 * never changes, this is sampling with replacement: the fraction of blue draws
 * should settle on the true fraction of blue balls as we draw more and more.
 */
public final class PracticeMain {

  private PracticeMain() {
    // Entry-point holder — not instantiated.
  }

  public static void main(String[] args) {
    Bag bag = new Bag();

    // Fill the urn with a known mix: 30 black, 70 blue. So 70% of the balls are
    // blue, and we expect roughly 70% of our draws to come up blue in the long
    // run. (Adding 100 balls to a bag that starts with room for 10 forces the
    // backing array to grow several times along the way.)
    int black = 30;
    int blue = 70;
    for (int i = 0; i < black; i++) {
      bag.add(BallColor.BLACK);
    }
    for (int i = 0; i < blue; i++) {
      bag.add(BallColor.BLUE);
    }
    double trueFraction = (double) blue / (black + blue);

    System.out.println("Bag holds " + black + " black and " + blue + " blue balls.");
    System.out.printf("True fraction blue: %.4f%n", trueFraction);
    System.out.println();
    System.out.println("draws      blue draws   observed fraction");

    // Draw many times. After each draw we put a same-color ball back, so the bag
    // always holds the same 30/70 mix. We report at 10, 100, 1000, ... draws to
    // see the observed fraction close in on the true one.
    int blueDraws = 0;
    int totalDraws = 100000;
    int nextReport = 10;
    for (int draw = 1; draw <= totalDraws; draw++) {
      BallColor ball = bag.remove();   // draw a ball at random
      if (ball == BallColor.BLUE) {
        blueDraws++;
      }
      bag.add(ball);                   // put a ball of the same color back

      if (draw == nextReport) {
        double observed = (double) blueDraws / draw;
        System.out.printf("%-10d %-12d %.4f%n", draw, blueDraws, observed);
        nextReport *= 10;
      }
    }
  }
}
