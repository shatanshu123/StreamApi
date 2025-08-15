package streamApiLearning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamAPI15Aug {
	public static void main(String[] args) {
		List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
		int sum = num.stream().map(n -> n * n).filter(n -> n % 2 == 0).reduce((a, b) -> a + b).orElse(-1);
		System.out.println(sum);

		List<String> word = Arrays.asList("running", "play", "eating", "sleep", "coding");
		List<String> end = word.stream().filter(n -> n.endsWith("ing")).collect(Collectors.toList());
		System.out.println(end);

		List<Integer> number = Arrays.asList(2, 3, 4);
		int product = number.stream().reduce((a, b) -> a * b).orElse(-1);
		System.out.println(product);

		List<Integer> number1 = Arrays.asList(1, 2, 3, 4, 5, 6, 8, 10);
		List<Integer> numbers1 = number1.stream().filter(n -> n % 2 == 0).limit(3).collect(Collectors.toList());
		System.out.println(numbers1);

		List<Integer> nums = Arrays.asList(15, 30, 45, 50, 60);
		List<Integer> fil = nums.stream().filter(n -> n % 3 == 0 && n % 5 == 0).collect(Collectors.toList());
		System.out.println(fil);

		List<String> words = Arrays.asList("sun", "sand", "school", "superintendent", "sea");
		Optional<String> starts = words.stream().max(Comparator.comparing(String::length))
				.filter(s -> s.startsWith("s") || s.startsWith("S"));
		System.out.println(starts.orElse("no"));

		List<String> wordss = Arrays.asList("apple", "banana", "cherry");
		String vowels = "aeiou";
		long count = wordss.stream().flatMapToInt(String::chars).mapToObj(c -> (char) c)
				.filter(ch -> vowels.indexOf(Character.toLowerCase(ch)) != -1) // keep vowels
				.count();
		System.out.println(count);

		List<Integer> numbers = Arrays.asList(5, 2, 8, 3, 9);
		List<Integer> sorted = numbers.stream().sorted().collect(Collectors.toList());
		int n = sorted.size();
		Object median = (n % 2 == 0) ? (sorted.get(n / 2 - 1) + sorted.get(n / 2)) / 2.0 : sorted.get(n / 2);

		System.out.println(median);
		
		 List<String> wors = Arrays.asList("Java", "java", "Python", "PYTHON", "C++");

	        List<String> distinct = wors.stream()
	            .collect(Collectors.collectingAndThen(
	                Collectors.toMap(String::toLowerCase, s -> s, (a, b) -> a, LinkedHashMap::new),
	                m -> new ArrayList<>(m.values())
	            ));

	        System.out.println(distinct);
	}
}
