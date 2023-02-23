package onjava.concurrent;

import java.util.concurrent.CompletableFuture;

final class Frosting {

  private Frosting() {
  }

  static CompletableFuture<Frosting> make() {
    new Nap(0.1);
    return CompletableFuture.completedFuture(new Frosting());
  }
}

public class FrostedCake {

  public FrostedCake(Baked baked, Frosting frosting) {
    new Nap(0.1);
  }

  public static void main(String[] args) {
    Baked.batch()
        .forEach(
            baked ->
                baked
                    .thenCombineAsync(
                        Frosting.make(), (cake, frosting) -> new FrostedCake(cake, frosting))
                    .thenAcceptAsync(System.out::println)
                    .join());
  }

  @Override
  public String toString() {
    return "FrostedCake";
  }
}
