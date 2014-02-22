package org.github.marcellodesales.collections;

import static java.lang.annotation.ElementType.TYPE_USE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParallelSorting {
  public static void main(String[] args) {

    List<String> strings = buildList(1423456);
    Instant p1 = Instant.now();
    Arrays.parallelSort(strings.toArray(new String[strings.size()]));
    System.out.println(Duration.between(Instant.now(), p1));

  }

  @Target({ TYPE_USE })
  @Retention(RetentionPolicy.SOURCE)
  public @interface SuppressW {
  }

  private static List<String> buildList(Integer n) {
    List<String> ret = new ArrayList<String>();
    for (int i = n; i > 0; i--) {
      ret.add(Integer.toString(i));
    }
    return ret;
  }

}
