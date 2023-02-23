package onjava;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class InstrumentedSafeHashSet<E> extends ForwardingSet<E> {

  private int addCount = 0;

  public InstrumentedSafeHashSet(Set<E> s) {
    super(s);
  }

  public static void main(String[] args) {
    InstrumentedSafeHashSet<String> set = new InstrumentedSafeHashSet<>(new HashSet<>());
    set.addAll(Arrays.asList("1", "2", "3"));
    System.out.println(set.getAddCount());
  }

  @Override
  public boolean add(E e) {
    addCount++;
    return super.add(e);
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    addCount += c.size();
    return super.addAll(c);
  }

  public int getAddCount() {
    return addCount;
  }
}
