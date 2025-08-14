package streamApiLearning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApi {
	public class TestMain {

		public static void main(String[] args) {
			List<String> words = Arrays.asList("Dog", "Cat", "Horse", "Elephant");
			List<String> wording = Arrays.asList("Red", "Green", "Blue");
			List<String> words1 = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
			Map<String, Long>ww=words1.stream().collect(Collectors.groupingBy(word->word,Collectors.counting()));
			String val = wording.stream().collect(Collectors.joining(","));
			List<String> rr = words.stream().filter(n -> n.startsWith("B")).collect(Collectors.toList());
			List<String> res = words.stream().map(String::toUpperCase).collect(Collectors.toList());
			Map<Character, List<String>> res1 = words.stream().collect(Collectors.groupingBy(word -> word.charAt(0)));
			Optional<String> res2 = words.stream().min(Comparator.comparingInt(String::length));
			List<String> result = words.stream().filter(n -> n.length() > 4).collect(Collectors.toList());
			List<String> r = words.stream().filter(n -> n.contains("o")).collect(Collectors.toList());
			System.out.println(res);
			System.out.println(res1);
			System.out.println(rr);
			System.out.println(res2.orElse("-1"));
			System.out.println(result);
			System.out.println(r);
			System.out.println(val);
			System.out.println(ww);
			// ----------------------------------------------------------------------------------------//

			List<Integer> ll = Arrays.asList(15, 42, 7, 98, 23);
			Set<Integer> res11 = ll.stream().collect(Collectors.toSet());
			List<Integer> num = Arrays.asList(5, 3, 9, 3, 5, 1);
			List<Integer> numbers = Arrays.asList(10, 20, 4, 45, 99);
			List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
			List<Integer> nums = num.stream().distinct().collect(Collectors.toList());
			Optional<Integer> rm = ll.stream().distinct().reduce((a, b) -> a * b);
			int sum = ll.stream().filter(n -> n % 2 == 0).reduce(0, (a, b) -> a + b);
			int rd = ll.stream().reduce(0, (a, b) -> a > b ? a : b);
			Optional<Integer> mx = numbers.stream().distinct().sorted((a, b) -> b - a).skip(1).findAny();
			Map<Boolean, List<Integer>> rss = numbers1.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
			System.out.println(res11);
			System.out.println(rm.orElse(-1));
			System.out.println(sum);
			System.out.println(rd);
			System.out.println(nums);
			System.out.println(mx.orElse(null));
			System.out.println("Even numbers are " + rss.get(true));
			System.out.println("Odd numbers are " + rss.get(false));
		}

	}
}
