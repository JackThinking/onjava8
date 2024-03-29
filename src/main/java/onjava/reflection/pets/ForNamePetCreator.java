// reflection/pets/ForNamePetCreator.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package onjava.reflection.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNamePetCreator extends Creator {

  private static List<Class<? extends Pet>> types =
      new ArrayList<>();
  // Types you want randomly created:
  private static String[] typeNames = {
      "reflection.pets.Mutt",
      "reflection.pets.Pug",
      "reflection.pets.EgyptianMau",
      "reflection.pets.Manx",
      "reflection.pets.Cymric",
      "reflection.pets.Rat",
      "reflection.pets.Mouse",
      "reflection.pets.Hamster"
  };

  static {
    loader();
  }

  @SuppressWarnings("unchecked")
  private static void loader() {
    try {
      for (String name : typeNames) {
        types.add(
            (Class<? extends Pet>) Class.forName(name));
      }
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Class<? extends Pet>> types() {
    return types;
  }
}
