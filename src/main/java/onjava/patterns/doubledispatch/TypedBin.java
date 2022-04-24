// patterns/doubledispatch/TypedBin.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// A List that can grab the right type.
package onjava.patterns.doubledispatch;

import onjava.patterns.trash.Trash;

import java.util.ArrayList;
import java.util.List;

// 将垃圾桶进行抽象
public class TypedBin {
  // 必须是私有的
  private List<Trash> typedBin = new ArrayList<>();
  public final String type;

  public TypedBin(String type) {
    this.type = type;
  }

  // 使用时只能使用副本
  public List<Trash> bin() {
    // Returns a copy of typedBin:
    return new ArrayList<>(typedBin);
  }

  // region 难点，add 函数是多态的
  protected boolean addIt(Trash t) {
    typedBin.add(t);
    return true;
  }

  public boolean add(Aluminum a) {
    return false;
  }

  public boolean add(Paper a) {
    return false;
  }

  public boolean add(Glass a) {
    return false;
  }

  public boolean add(Cardboard a) {
    return false;
  }
  // endregion
}
