package onjava.generics;

// generics/GenericArray2.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class GenericArray2<T> {

  private Object[] array;

  public GenericArray2(int sz) {
    array = new Object[sz];
  }

  public static void main(String[] args) {
    GenericArray2<Integer> gai = new GenericArray2<>(10);
    for (int i = 0; i < 10; i++) {
      gai.put(i, i);
    }
    for (int i = 0; i < 10; i++) {
      System.out.print(gai.get(i) + " ");
    }
    System.out.println();
    try {
      Integer[] ia = gai.rep();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void put(int index, T item) {
    array[index] = item;
  }

  @SuppressWarnings("unchecked")
  public T get(int index) {
    return (T) array[index];
  }

  @SuppressWarnings("unchecked")
  public T[] rep() {
    return (T[]) array; // Unchecked cast
  }
}
/* Output:
0 1 2 3 4 5 6 7 8 9
java.lang.ClassCastException: [Ljava.lang.Object;
cannot be cast to [Ljava.lang.Integer;
*/
