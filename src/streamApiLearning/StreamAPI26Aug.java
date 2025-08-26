package streamApiLearning;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI26Aug {

	public static void main(String[] args) {
		List<List<Integer>> numbers = List.of(List.of(1, 2), List.of(3, 4));
		List<Stream<Integer>> mapped = numbers.stream().map(List::stream).toList();
		System.out.println(mapped);
		List<Integer> flatMapped = numbers.stream().flatMap(List::stream).toList();
		System.out.println(flatMapped);

		List<String> words = List.of("apple", "banana", "apple");
		Map<String, Integer> map = words.stream().collect(Collectors.toMap(w -> w, w -> 1, Integer::sum));
		System.out.println(map);

		List<Integer> first10 = Stream.iterate(1, n -> n + 1).limit(10).toList();
		System.out.println(first10);

		Set<String> set = Stream.of("b", "a", "c").collect(Collectors.toSet()); // may not preserve order
		System.out.println(set);
		Set<String> ordered = Stream.of("b", "a", "c").collect(Collectors.toCollection(LinkedHashSet::new)); // preserves
		System.out.println(ordered); // order
		
		
	}

}
