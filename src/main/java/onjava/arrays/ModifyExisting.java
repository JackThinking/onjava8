package onjava.arrays;

import static onjava.ArrayShow.show;

import java.util.Arrays;
import onjava.Rand;

public class ModifyExisting {

  public static void main(String[] args) {
    double[] da = new double[7];
    Arrays.setAll(da, new Rand.Double()::get);
    show(da);
    Arrays.setAll(da, n -> da[n] / 100); // [1]
    show(da);
  }
}
/* Output:
[4.83, 2.89, 2.9, 1.97, 3.01, 0.18, 0.99]
[0.0483, 0.028900000000000002, 0.028999999999999998,
0.0197, 0.0301, 0.0018, 0.009899999999999999]
*/
