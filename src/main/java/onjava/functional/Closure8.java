package onjava.functional; // functional/Closure8.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Closure8 {

  public static void main(String[] args) {
    Closure8 c7 = new Closure8();
    List<Integer> l1 = c7.makeFun().get(), l2 = c7.makeFun().get();
    System.out.println(l1);
    System.out.println(l2);
    l1.add(42);
    l2.add(96);
    System.out.println(l1);
    System.out.println(l2);
  }

  Supplier<List<Integer>> makeFun() {
    final List<Integer> ai = new ArrayList<>();
    ai.add(1);
    return () -> ai;
  }
}
/* Output:
[1]
[1]
[1, 42]
[1, 96]
*/
