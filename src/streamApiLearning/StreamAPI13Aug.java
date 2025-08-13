package streamApiLearning;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamAPI13Aug {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1, 2, 3, 4);
		List<Integer> nums1 = nums.stream().map(n -> n * 3).collect(Collectors.toList());
		System.out.println(nums1);

		List<Integer> num = Arrays.asList(5, 12, 45, 60, 25, 8);
		List<Integer> num1 = num.stream().filter(n -> (n >= 10 && n <= 50)).collect(Collectors.toList());
		System.out.println(num1);

		List<Integer> number = Arrays.asList(7, 2, 9, 4, 1);
		Optional<Integer> number1 = number.stream().sorted((a, b) -> a - b).findFirst();
		System.out.println(number1.orElse(-1));

		List<Integer> numbers = Arrays.asList(5, 1, 9, 3, 7);
		List<Integer> numbers1 = numbers.stream().sorted((a, b) -> b - a).collect(Collectors.toList());
		System.out.println(numbers1);

		List<Integer> numberss = Arrays.asList(1, 2, 3, 4, 5, 6);
		Integer numberss1 = numberss.stream().filter(n -> n % 2 == 0).reduce(0, (a, b) -> a + b);
		System.out.println(numberss1);
		
		List<String> word = Arrays.asList("Java", "Stream", "API");
		String word1 = word.stream().collect(Collectors.joining("-"));
		System.out.println(word1);
		
		List<String> words = Arrays.asList("apple", "orange", "grape", "banana");
		List<String> words1 =words.stream().filter(n->n.endsWith("e")).collect(Collectors.toList());
		System.out.println(words1);
		
		List<Integer> numbersss = Arrays.asList(3, 1, 4, 2);
		List<Integer> numbersss1 =numbersss.stream().map(n->n*n).sorted((a,b)->a-b).collect(Collectors.toList());
		System.out.println(numbersss1);
		
		List<Integer> numbs = Arrays.asList(5, 2, 8, 1, 3);
		Optional<Integer> numbs1 = numbs.stream().sorted((a,b)->a-b).skip(1).findFirst();
		System.out.println(numbs1.orElse(-1));
	}

}
