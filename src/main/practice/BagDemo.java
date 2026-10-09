package practice;

/** Treats the bag as an urn and draws from it many times to watch a probability take shape. */
public final class BagDemo {

  private BagDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    Bag bag = new Bag();

    // Known mix: 30 black, 70 blue, so we expect roughly 70% of draws to come up blue.
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

    // Sampling with replacement: put a same-color ball back after every draw, so
    // the mix never changes and the observed fraction should settle on the true one.
    int blueDraws = 0;
    int totalDraws = 100000;
    int nextReport = 10;
    for (int draw = 1; draw <= totalDraws; draw++) {
      BallColor ball = bag.remove();
      if (ball == BallColor.BLUE) {
        blueDraws++;
      }
      bag.add(ball);

      if (draw == nextReport) {
        double observed = (double) blueDraws / draw;
        System.out.printf("%-10d %-12d %.4f%n", draw, blueDraws, observed);
        nextReport *= 10;
      }
    }
  }
}
