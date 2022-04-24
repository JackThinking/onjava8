// patterns/doubledispatch/Aluminum.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Aluminum with double dispatching.
package onjava.patterns.doubledispatch;

import java.util.List;

public class Aluminum extends onjava.patterns.trash.Aluminum implements TypedBinMember {
  public Aluminum(double wt) {
    super(wt);
  }

  @Override
  public boolean addToBin(List<TypedBin> tbins) {
    // this 其实是多态的
    return tbins.stream().anyMatch(tb -> tb.add(this));
  }
}
