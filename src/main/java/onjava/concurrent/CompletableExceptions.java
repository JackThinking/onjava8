package onjava.concurrent;

import java.util.concurrent.CompletableFuture;

public class CompletableExceptions {

  static CompletableFuture<Breakable> test(String id, int failcount) {
    return CompletableFuture.completedFuture(new Breakable(id, failcount))
        .thenApply(Breakable::work)
        .thenApply(Breakable::work)
        .thenApply(Breakable::work)
        .thenApply(Breakable::work);
  }

  public static void main(String[] args) {
    // Exceptions don't appear ...
    test("A", 1);
    test("B", 2);
    test("C", 3);
    test("D", 4);
    test("E", 5);
    // ... until you try to fetch the value:
    try {
      test("F", 2).get(); // or join()
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    // Test for exceptions:  G 表明，你可以首先检查在处理期间是否抛出异常，而不抛出该异常
    System.out.println(test("G", 2).isCompletedExceptionally());
    // Counts as "done":  H 告诉我们，不管异常是否成功，它仍然被视为已 “完成
    System.out.println(test("H", 2).isDone());
    // Force an exception:
    CompletableFuture<Integer> cfi = new CompletableFuture<>();
    System.out.println("done? " + cfi.isDone());
    cfi.completeExceptionally(new RuntimeException("forced"));
    try {
      cfi.get();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
/* Output:
Throwing Exception for A
Breakable_B [1]
Throwing Exception for B
Breakable_C [2]
Breakable_C [1]
Throwing Exception for C
Breakable_D [3]
Breakable_D [2]
Breakable_D [1]
Throwing Exception for D
Breakable_E [4]
Breakable_E [3]
Breakable_E [2]
Breakable_E [1]
Breakable_F [1]
Throwing Exception for F
java.lang.RuntimeException: Breakable_F failed
Breakable_G [1]
Throwing Exception for G
true
Breakable_H [1]
Throwing Exception for H
true
done? false
java.lang.RuntimeException: forced
*/
