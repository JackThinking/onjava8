package onjava.concurrent;

import java.util.concurrent.CompletableFuture;

import static onjava.concurrent.CompletableUtilities.showr;
import static onjava.concurrent.CompletableUtilities.voidr;

public class CompletableOperations {
  static CompletableFuture<Integer> cfi(int i) {
    return CompletableFuture.completedFuture(Integer.valueOf(i));
  }

  public static void main(String[] args) {
    showr(cfi(1)); // Basic test
    // runAsync() 是一个 static 方法
    voidr(cfi(2).runAsync(() -> System.out.println("runAsync")));
    voidr(cfi(3).thenRunAsync(() -> System.out.println("thenRunAsync")));
    voidr(CompletableFuture.runAsync(() -> System.out.println("runAsync is static")));
    // supplyAsync() 也是静态方法
    showr(CompletableFuture.supplyAsync(() -> 99));
    voidr(cfi(4).thenAcceptAsync(i -> System.out.println("thenAcceptAsync: " + i)));
    showr(cfi(5).thenApplyAsync(i -> i + 42));
    // 与 thenApplyAsync() 非常相似，唯一区别在于其 Function 必须产生已经包装在 CompletableFuture 中的结果
    showr(cfi(6).thenComposeAsync(i -> cfi(i + 99)));
    CompletableFuture<Integer> c = cfi(7);
    c.obtrudeValue(111);
    showr(c);
    showr(cfi(8).toCompletableFuture());
    // 如何通过给它一个结果来完成一个 task
    c = new CompletableFuture<>();
    c.complete(9);
    showr(c);
    // 调用 CompletableFuture 中的 cancel() 方法，如果已经完成此任 务，则正常结束
    c = new CompletableFuture<>();
    c.cancel(true);
    System.out.println("cancelled: " + c.isCancelled());
    System.out.println("completed exceptionally: " + c.isCompletedExceptionally());
    System.out.println("done: " + c.isDone());
    System.out.println(c);
    // 如果任务(future)完成，则 getNow() 方法返回 CompletableFuture 的
    // 完成值，否则返回 getNow() 的替换参数。
    c = new CompletableFuture<>();
    System.out.println(c.getNow(777));
    c = new CompletableFuture<>();
    c.thenApplyAsync(i -> i + 42).thenApplyAsync(i -> i * 12).thenApplyAsync(i -> i * 12);
    System.out.println("dependents: " + c.getNumberOfDependents());
    c.thenApplyAsync(i -> i / 2);
    System.out.println("dependents: " + c.getNumberOfDependents());
  }
}
/* Output:
1
runAsync
thenRunAsync
runAsync is static
99
thenAcceptAsync: 4
47
105
111
8
9
cancelled: true
completed exceptionally: true
done: true
java.util.concurrent.CompletableFuture@1629346[Complete
d exceptionally]
777
dependents: 1
dependents: 2
*/
