package streamApiLearning;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPI22Aug {

	public static void main(String[] args) {
		List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5),
				Arrays.asList(6, 7, 8));
		List<Integer> flatMap = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
		System.out.println(flatMap);

		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);
		List<Integer> common = list1.stream().filter(list2::contains).collect(Collectors.toList());
		System.out.println(common);

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		Map<Boolean, List<Integer>> partion = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
		System.out.println("Even -> " + partion.get(true));
		System.out.println("Odd -> " + partion.get(false));

		String sentence = "hello world hello java world";
		Map<String, Long> frequency = Arrays.stream(sentence.split(" "))
				.collect(Collectors.groupingBy(n -> n, Collectors.counting()));
		System.out.println(frequency);
	}

}
