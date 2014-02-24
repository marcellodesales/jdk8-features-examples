package org.github.marcellodesales.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamBulkOperationsMapFunction {

  static class Word {
    public Word(String word) {
      original = word;
    }
    public String original;
    public String getKey() {
      return sortChars(original);
    }

    public String toString() {
      return original;
    };
  }

  public static String sortChars(String input) {
    char[] characters = input.toCharArray();
    Arrays.sort(characters);
    return new String(characters);
  }

  public static void main(String[] args) {

    // using pojo and the getter method
    List<Word> words = Arrays.asList(new Word("pool"), new Word("loop"), new Word("stream"), new Word("arc"),
        new Word("odor"), new Word("car"), new Word("rood"), new Word("meats"), new Word("fires"), new Word("fries"),
        new Word("night"), new Word("thing"), new Word("mates"), new Word("teams"));

    Map<String, List<Word>> joined2 = words.stream().collect(Collectors.groupingBy(Word::getKey));
    System.out.println(joined2);

    // using a regular list of strings
    List<String> words2 = Arrays.asList("pool", "loop", "stream", "arc",
        "odor", "car", "rood", "meats", "fires", "fries",
        "night", "thing", "mates", "teams");

    Map<String, List<String>> anagrams = words2.stream().collect(Collectors.groupingBy(w -> sortChars(w)));
    System.out.println(anagrams);
    //{door=[odor, rood], acr=[arc, car], ghint=[night, thing], aemrst=[stream], efirs=[fires, fries], 
    //       loop=[pool, loop], aemst=[meats, mates, teams]}

    Map<String, List<String>> anagrams2 =
        words2.stream().collect(Collectors.groupingBy(StreamBulkOperationsMapFunction::sortChars));
    System.out.println(anagrams2);

//    String joined = "Marcello".stream().map(Object::toString)
//        .collect(Collectors.joining(", "));
    
//    words.stream().map(w -> new String(w.toCharArray()).collect().forEach(System.out::println);

//    words.stream().map(w -> w.chars().sorted().boxed().collect(Collectors.joining(""))).forEach(System.out::println);
  }
}
