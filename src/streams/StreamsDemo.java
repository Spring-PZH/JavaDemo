package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsDemo {
  public static void show() {
    List<String> list = Arrays.asList("apple","android", "banana", "cherry");

    var result = list.stream()
//            .peek(s -> System.out.println("Original element: " + s))
            .filter(s -> s.startsWith("a"))
//            .peek(s -> System.out.println("Filtered element: " + s))
            .map(String::toUpperCase)
//            .peek(s -> System.out.println("Mapped element: " + s))
            .collect(Collectors.summarizingInt(String::length));

    System.out.println("Result: " + result);

    Optional<String> maxWord = list.stream().max(String::compareTo);
    maxWord.ifPresent(System.out::println); // 输出: cherry

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    Optional<Integer> maxNumber = numbers.stream().max(Integer::compareTo);

  }
}
