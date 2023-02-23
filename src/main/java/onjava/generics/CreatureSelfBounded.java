package onjava.generics;

public class CreatureSelfBounded<T extends CreatureSelfBounded<T>> {

  private String species;

  public static void main(String[] args) {
    CatSelfBounded cat = new CatSelfBounded().setSpecies("cat").setCoatColor("red");
    System.out.printf("%s,%s%n", cat.getSpecies(), cat.getCoatColor());
  }

  public String getSpecies() {
    return species;
  }

  public T setSpecies(String species) {
    // 在基类里返回了子类
    this.species = species;
    return (T) this;
  }
}

class CatSelfBounded extends CreatureSelfBounded<CatSelfBounded> {

  private String coatColor;

  public String getCoatColor() {
    return coatColor;
  }

  public CatSelfBounded setCoatColor(String coatColor) {
    this.coatColor = coatColor;
    return this;
  }
}
