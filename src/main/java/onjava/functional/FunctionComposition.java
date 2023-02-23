package onjava.functional; // functional/FunctionComposition.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.function.Function;

public class FunctionComposition {

  public static void main(String[] args) {
    System.out.println(f4.apply("GO AFTER ALL AMBULANCES"));
    System.out.println(f5.apply("GO AFTER ALL AMBULANCES"));
  }  static Function<String, String>
      f1 =
      s -> {
        System.out.println(s);
        return s.replace('A', '_');
      },
      f2 = s -> s.substring(3),
      f3 = String::toLowerCase,
      f4 = f1.compose(f2).andThen(f3),
      f5 = f2.andThen(f1).andThen(f3);


}
/* Output:
AFTER ALL AMBULANCES
_fter _ll _mbul_nces
*/
