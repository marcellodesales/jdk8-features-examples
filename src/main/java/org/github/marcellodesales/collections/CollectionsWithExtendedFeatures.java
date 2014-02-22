package org.github.marcellodesales.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class CollectionsWithExtendedFeatures {

  public static void main(String[] args) {

    HashSet<String> set = new HashSet<String>(Arrays.asList("Marcello", "Leandro", "Thiago"));

    // Collection.remove(Predicate)
    // set.removeAll();
    System.out.println(set);

    // List.replaceAll
    List<String> list = Arrays.asList("Alves", "Melo", "Bruno");
    // appends something to all of the elements
    list.replaceAll(a -> a + "1");
    System.out.println(list);

    // List.sort
    list.sort(Comparator.naturalOrder());
    System.out.println(list);

  }

}
