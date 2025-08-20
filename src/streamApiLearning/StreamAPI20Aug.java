package streamApiLearning;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI20Aug {

	public static void main(String[] args) {
		String input = "hello world hello java world";
		Map<String, Long> wordCount = Arrays.stream(input.split(" "))
				.collect(Collectors.groupingBy(word -> word, Collectors.counting()));
		System.out.println(wordCount);

		List<String> words = Arrays.asList("apple", "banana", "apricot", "blueberry");
		Map<Character, List<String>> ans = words.stream().collect(Collectors.groupingBy(n -> n.charAt(0)));
		System.out.println(ans);

		List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 1, 6);
		Set<Integer> seen = new HashSet<>();
		List<Integer> nums = numbers.stream().filter(no -> !seen.add(no)).distinct().collect(Collectors.toList());
		System.out.println(nums);

		String inputs = "banana";
		Map<Character, Long> numbs = inputs.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		System.out.println(numbs);

		String inputVal = "swiss";
		Character firstNonRepeated = inputVal.chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(ch -> ch, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);
		System.out.println(firstNonRepeated);

		List<String> word = Arrays.asList("madam", "apple", "racecar", "java");
		List<String> word1 = word.stream()
				.filter(str -> str.equalsIgnoreCase(new StringBuilder(str).reverse().toString()))
				.collect(Collectors.toList());
		System.out.println(word1);

		List<String> wording = Arrays.asList("apple", "bat", "car", "elephant", "dog");
		Map<Integer, List<String>> grouped = wording.stream().collect(Collectors.groupingBy(String::length));
		grouped.forEach((len, length) -> System.out.println(len + " -> " + length));

		List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
		List<Integer> list2 = Arrays.asList(3, 4, 5, 6);
		List<Integer> concat = Stream.concat(list1.stream(), list2.stream()).distinct().collect(Collectors.toList());
		System.out.println(concat);

		List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> l2 = Arrays.asList(3, 4, 5, 6, 7);
		List<Integer> newl = l1.stream().filter(l2::contains).collect(Collectors.toList());
		System.out.println(newl);

		List<Integer> sqNumbers = Arrays.asList(2, 3, 4, 2, 3, 5);
		List<Integer> sqNumbers1 = sqNumbers.stream().map(ns -> ns * ns).distinct().collect(Collectors.toList());
		System.out.println(sqNumbers1);
		
		
	}

}
