package streamApiLearning;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamAPI12Aug {
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
		List<Integer> nums1 = nums.stream().distinct().collect(Collectors.toList());
		System.out.println(nums1);

		List<Integer> num = Arrays.asList(5, 8, 12, 3, 7, 10);
		Optional<Integer> num1 = num.stream().filter(n -> n % 2 == 0).reduce((a, b) -> a + b);
		System.out.println(num1.orElse(-1));

		List<Integer> number = Arrays.asList(7, 3, 9, 1, 4);
		Optional<Integer> number1 = number.stream().sorted((a, b) -> a - b).findFirst();
		System.out.println(number1.orElse(-1));

		List<String> strings = Arrays.asList("2025", "08", "12");
		String strings1 = strings.stream().collect(Collectors.joining("-"));
		System.out.println(strings1);

		List<Integer> numbers = Arrays.asList(2, 3, 4);
		List<Integer> numbers1 = numbers.stream().map(n -> n * n).collect(Collectors.toList());
		System.out.println(numbers1);

		List<String> stringss = Arrays.asList("cat", "dog", "mouse", "rat");
		List<String> stringss1 = stringss.stream().filter(n -> n.contains("a")).collect(Collectors.toList());
		System.out.println(stringss1);

		List<Integer> numberss = Arrays.asList(10, 20, 30, 40);
		double avg = numberss.stream().mapToInt(Integer::intValue).average().orElse(-1);
		System.out.println(avg);

		List<Integer> numbs = Arrays.asList(3, 5, 3, 2, 5, 3, 4);
		Integer numbs1 = numbs.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting())).entrySet()
				.stream().max(Map.Entry.comparingByValue()).get().getKey();
		System.out.println(numbs1);

		List<String> words = Arrays.asList("Java", "", "Stream", "", "API");
		List<String> words1 = words.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
		System.out.println(words1);

		List<String> wordss = Arrays.asList("madam", "level", "apple", "radar", "java");
		List<String> wordss1 = wordss.stream().filter(s -> s.equalsIgnoreCase(new StringBuilder(s).reverse().toString())).collect(Collectors.toList());
		System.out.println(wordss1);
	}
}
