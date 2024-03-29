package onjava.functional;

interface MakeNoArgs {

  Dog make();
}

interface Make1Arg {

  Dog make(String nm);
}

interface Make2Args {

  Dog make(String nm, int age);
}

class Dog {

  String name;
  int age = -1; // For "unknown"

  Dog() {
    name = "stray";
  }

  Dog(String nm) {
    name = nm;
  }

  Dog(String nm, int yrs) {
    name = nm;
    age = yrs;
  }
}

public class CtorReference {

  public static void main(String[] args) {
    MakeNoArgs mna = Dog::new; // [1]
    Make1Arg m1a = Dog::new; // [2]
    Make2Args m2a = Dog::new; // [3]

    Dog dn = mna.make();
    Dog d1 = m1a.make("Comet");
    Dog d2 = m2a.make("Ralph", 4);
  }
}
