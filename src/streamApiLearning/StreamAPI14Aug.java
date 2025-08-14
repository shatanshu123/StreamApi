package streamApiLearning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamAPI14Aug {
	public static void main(String[] args) {
		List<Integer> num = Arrays.asList(2, 3, 4, 5, 6);
		Optional<Integer> num1 = num.stream().map(n -> n * n).filter(n -> n % 2 == 0).reduce((a, b) -> a + b);
		System.out.println(num1.orElse(-1));

		List<String> word = Arrays.asList("I love Java", "Python is great", "Java Streams", "C++");
		List<String> word1 = word.stream().filter(s -> s.contains("Java")).collect(Collectors.toList());
		System.out.println(word1);

		List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
		double avg = numbers.stream().mapToInt(Integer::intValue).average().orElse(-1);
		List<Integer> numbers1 = numbers.stream().filter(n -> n > avg).collect(Collectors.toList());
		System.out.println(numbers1);

		List<String> words = Arrays.asList("apple", "banana", "cherry");
		List<String> words1 = words.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(words1);

		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
		String nums1 = nums.stream().map(String::valueOf).collect(Collectors.joining("-"));
		System.out.println(nums1);

		List<String> wordss = Arrays.asList("cat", "elephant", "tiger");
		int length = wordss.stream().mapToInt(String::length).max().orElse(-1);
		System.out.println(length);

		List<Integer> numbs = Arrays.asList(1, 2, 3, 4);
		boolean numbs1 = numbs.stream().allMatch(n -> n > 0);
		System.out.println(numbs1);

		List<Integer> numb = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> numb1 = numb.stream().skip(numb.size() - 3).collect(Collectors.toList());
		System.out.println(numb1);

		List<Integer> numbes = Arrays.asList(1, 2, 2, 3, 4, 4, 5);

		List<Integer> duplicates = numbes.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey)
				.collect(Collectors.toList());

		System.out.println(duplicates);

		List<Integer> nus = Arrays.asList(-5, 3, -2, 7, 0);
		Map<String, List<Integer>> grouped = nus.stream()
				.collect(Collectors.groupingBy(n -> {
					if(n==0)return "Zero";
					else if(n>0) return "Positive";
					else return "Negative";
				}));
		System.out.println(grouped);

	}
}
