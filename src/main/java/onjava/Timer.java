package onjava;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

public class Timer {

  private long start = System.nanoTime();

  public static long duration(Runnable test) {
    Timer timer = new Timer();
    test.run();
    return timer.duration();
  }

  public long duration() {
    return NANOSECONDS.toMillis(System.nanoTime() - start);
  }
}
