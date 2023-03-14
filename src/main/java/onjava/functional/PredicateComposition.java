package onjava.functional; // functional/PredicateComposition.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateComposition {

  public static void main(String[] args) {
    Stream.of("bar", "foobar", "foobaz", "fongopuckey").filter(p4).forEach(System.out::println);
  }

  static Predicate<String> p1 = s -> s.contains("bar"),
      p2 = s -> s.length() < 5,
      p3 = s -> s.contains("foo"),
      p4 = p1.negate().and(p2).or(p3);


}
/* Output:
foobar
foobaz
*/
