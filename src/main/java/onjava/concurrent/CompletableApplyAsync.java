package onjava.concurrent;

import java.util.concurrent.CompletableFuture;
import onjava.Timer;

public class CompletableApplyAsync {

  public static void main(String[] args) {
    Timer timer = new Timer();
    CompletableFuture<Machina> cf =
        CompletableFuture.completedFuture(new Machina(0))
            .thenApplyAsync(Machina::work)
            .thenApplyAsync(Machina::work)
            .thenApplyAsync(Machina::work)
            .thenApplyAsync(Machina::work);
    System.out.println(timer.duration());
    System.out.println(cf.join());
    System.out.println(timer.duration());
  }
}
/* Output:
103
Machina0: ONE
Machina0: TWO
Machina0: THREE
Machina0: complete
Machina0: complete
545
*/
