package org.github.marcellodesales.interfaces;

/**
 * Extension Methods Demo.
 *
 * @author Edwin Dalorzo
 */
public class DefaultInterfaceMethodWithResolution {

  interface Warrior {

    public default String fight() {
      return getMessage();
    }

    public static String getMessage() {
      return "Warriors fight";
    }
  }

  interface Ninja extends Warrior {

    public default String fight() {
      return Warrior.super.fight() + " and Ninjas fight too";
    }

  }

  interface Samurai extends Warrior {
    public default String fight() {
      return "Samurais are the best warriors";
    }
  }

  public static class Jiraia implements Warrior {
    // no default method needed to be implemented by an abstract class or the concrete class
  }

  public static class Goku implements Ninja, Samurai {

    // Here's the compiler message about not implementing it.

    // Duplicate default methods named fight with the parameters () and () are inherited from the 
    // types DefaultInterfaceMethodWithResolution.Samurai and DefaultInterfaceMethodWithResolution.Ninja
    public String fight() {
      return Ninja.super.fight();
    }

  }

  public static void main(String[] args) {

    Goku goku = new Goku();
    System.out.println(goku.fight());
    // Warriors fight and Ninjas fight too

    System.out.println(new Jiraia().fight());
    // Warriors fight
  }

}
