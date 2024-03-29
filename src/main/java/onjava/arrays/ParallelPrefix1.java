package onjava.arrays;

import static onjava.ArrayShow.show;

import java.util.Arrays;
import onjava.Count;

public class ParallelPrefix1 {

  public static void main(String[] args) {
    int[] nums = new Count.Pint().array(10);
    show(nums);
    System.out.println(Arrays.stream(nums).reduce(Integer::sum).getAsInt());
    Arrays.parallelPrefix(nums, Integer::sum);
    show(nums);
    System.out.println(Arrays.stream(new Count.Pint().array(6)).reduce(Integer::sum).getAsInt());
  }
}
/* Output:
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
45
[0, 1, 3, 6, 10, 15, 21, 28, 36, 45]
15
*/
