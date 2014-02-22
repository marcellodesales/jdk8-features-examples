package org.github.marcellodesales.annotations;

import static java.lang.annotation.ElementType.TYPE_USE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class TypesCanHaveAnnotation {
  public static void main(String[] args) {

    String a = "successed";

    // can be used for language processing, converters, etc, during static code analysis.
    @Status
    String b = "failed";

    System.out.println((@Status String) a);
    System.out.println(b);
  }

  @Target({ TYPE_USE })
  @Retention(RetentionPolicy.SOURCE)
  public @interface Status {
  }

}
