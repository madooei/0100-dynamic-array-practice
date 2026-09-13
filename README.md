# Dynamic Array — Practice: Build a Bag

A growable bag of colored balls you draw from at random, built the same way as the chapter's `DynamicArray`: a fixed-size backing array that doubles in capacity when it fills up.

## Prerequisites

- JDK 17+

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  src/
    main/
      practice/
        BallColor.java      # the two ball colors, as an enum
        Bag.java             # a growable bag you draw from at random
        PracticeMain.java    # the urn probability demo
  scripts/
    run.sh                   # compile everything and run the Bag urn demo
```

## How to compile and run

- `scripts/run.sh` — compiles all source into `out/` and runs the urn probability demo (`practice.PracticeMain`).

There is no build tool and no test suite: testing is introduced later in the course. The script above is all you need.

## What's here

- `practice.Bag` — a growable bag of colored balls with `add`, `remove` (which draws a ball at random and hands it back), and `size`. Like `DynamicArray` it grows a fixed array, but because a bag is unordered, removal fills the gap with the last ball instead of shifting.
- `practice.BallColor` — the element type, an enum of `BLACK` and `BLUE`.
- `practice.PracticeMain` — fills the bag with a known mix and draws from it many times to watch the observed fraction of blue draws converge on the true proportion.
