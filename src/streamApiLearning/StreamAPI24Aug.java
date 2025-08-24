package streamApiLearning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamAPI24Aug {
	private static boolean isPrime(int num) {
		return IntStream.rangeClosed(2, (int) Math.sqrt(num)).allMatch(i -> num % i != 0);
	}

	public static void main(String[] args) {
		List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));
		List<Integer> ans = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
		System.out.println(ans);

		List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8);
		Map<Boolean, List<Integer>> partitioned = numbers.stream()
				.collect(Collectors.partitioningBy(StreamAPI24Aug::isPrime));
		System.out.println("Prime -> " + partitioned.get(true));
		System.out.println("Non Prime -> " + partitioned.get(false));

		String str = "Java streams make coding elegant";
		String word = Arrays.stream(str.split(" ")).max(Comparator.comparing(String::length)).orElse("Sorry");
		System.out.println(word);

		Set<Integer> seen = new HashSet<>();
		List<Integer> nums = Arrays.asList(1, 2, 3, 2, 4, 5, 1, 6);
		List<Integer> duplicates = nums.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting())) // Map<Integer,
																												// Long>
				.entrySet().stream().filter(e -> e.getValue() > 1) // keep only duplicates
				.map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println(duplicates);

		List<String> words = Arrays.asList("listen", "silent", "enlist", "hello", "world");

		List<String> anagrams = words.stream()
				// group words by their "sorted" form
				.collect(Collectors.groupingBy(wor -> wor.chars().sorted()
						.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString()))
				.values().stream()
				// only keep groups where size > 1
				.filter(group -> group.size() > 1).flatMap(List::stream).collect(Collectors.toList());

		System.out.println(anagrams);

		String hello = "hello world hello java world";
		Map<String, Long> frequencyMap = Arrays.stream(hello.split(" "))
				.collect(Collectors.groupingBy(w -> w, Collectors.counting()));
		System.out.println(frequencyMap);
	}
}
