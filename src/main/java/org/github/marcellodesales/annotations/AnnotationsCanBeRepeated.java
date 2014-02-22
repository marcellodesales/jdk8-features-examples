package org.github.marcellodesales.annotations;

import java.lang.annotation.*;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class AnnotationsCanBeRepeated {

  public static String paramName;

  @Release(Type.DEVELOPMENT)
  @Release(Type.QUALITY)
  public static void main(String[] bb) {

    Arrays.asList(new AnnotationsCanBeRepeated().getClass().getDeclaredMethods()).stream()
        .filter(method -> "main".equals(method.getName()))
        .findFirst()
        .ifPresent(method -> System.out.println("annotations: " + method.getAnnotations()[0]));

    System.out.println("Params:");
    // parameter name
    Arrays.asList(new AnnotationsCanBeRepeated().getClass().getDeclaredMethods()).stream()
        .filter(m -> "example".equals(m.getName()))
        .flatMap(m -> Arrays.asList(m.getParameters()).stream())
        .map(Parameter::getName).forEach(System.out::println);

    System.out.println("All methods:");
    Arrays.asList(new AnnotationsCanBeRepeated().getClass().getDeclaredMethods()).stream()
        .forEach(m -> System.out.println(m.getName()));
  }

  public static void example(String a, String b) {

  }

  enum Type {
    PRODUCTION,
    DEVELOPMENT,
    QUALITY
  }

  @Repeatable(Cycle.class)
  @interface Release {
    Type value();
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.METHOD)
  @interface Cycle {
    Release[] value();
  }
}
