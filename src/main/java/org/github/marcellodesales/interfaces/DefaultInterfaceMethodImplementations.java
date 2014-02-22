package org.github.marcellodesales.interfaces;

public class DefaultInterfaceMethodImplementations {

  public static void main(String[] args) {

    // default method
    System.out.println("B " + new B().name());

    System.out.println("C " + new C().name());

    // more general
    System.out.println("D " + new D().name("param"));

  }

  interface A {
    default String name() {
      return "default method";
    }
  }

  static class B implements A {
  }

  static class C implements A {
    public String name() {
      return "overriden method ";
    }
  }

  interface E extends G {
    default String name(String s) {
      return "more specific";
    }
  }

  interface F {
    default String name(CharSequence s) {
      return "more general";
    }
  }

  interface G {
    default String name(String s) {
      return "more specific 1";
    }
  }

  static class D implements F, E {
  }

}
