package onjava.arrays;

import static onjava.ArrayShow.show;

import java.util.Arrays;
import onjava.Rand;

public class ParallelPrefix2 {

  public static void main(String[] args) {
    String[] strings = new Rand.String(1).array(8);
    show(strings);
    Arrays.parallelPrefix(strings, (a, b) -> a + b);
    show(strings);
  }
}
/* Output:
[b, t, p, e, n, p, c, c]
[b, bt, btp, btpe, btpen, btpenp, btpenpc, btpenpcc]
*/
