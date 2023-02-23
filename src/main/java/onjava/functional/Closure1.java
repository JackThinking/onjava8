package onjava.functional;

import java.util.function.IntSupplier;

public class Closure1 {

  int i;

  public static void main(String[] args) {
    Closure1 closure1 = new Closure1();
    System.out.println(closure1.makeFun(1).getAsInt());
    System.out.println(closure1.makeFun(1).getAsInt());
    System.out.println(new Closure1().makeFun(1).getAsInt());
  }

  IntSupplier makeFun(int x) {
    return () -> x + i++;
  }
}
