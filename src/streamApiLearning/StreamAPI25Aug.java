package streamApiLearning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPI25Aug {
	public static void main(String[] args) {
		String input = "apple banana apple orange banana apple";
		int N = 2;
		List<String> words = Arrays.asList(input.split("\\s+"));
		Map<String, Long> frequencyMap = words.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		LinkedHashMap<String, Long> topN = frequencyMap.entrySet().stream()
				.sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())).limit(N)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		topN.forEach((word, count) -> System.out.println(word + "=" + count));

		List<Integer> number = Arrays.asList(5, 3, 9, 7, 9, 2);
		long second = number.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1);
		System.out.println(second);

		List<List<Integer>> flat = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 4), Arrays.asList(4, 5));
		List<Integer> flats = flat.stream().flatMap(List::stream).distinct().collect(Collectors.toList());
		System.out.println(flats);

		List<Integer> numbers = Arrays.asList(5, 12, 18, 7, 25);

		Map<String, List<Integer>> grouped = numbers.stream().collect(Collectors.groupingBy(num -> {
			int lower = (num - 1) / 10 * 10 + 1; // range start
			int upper = lower + 9; // range end
			return lower + "–" + upper;
		}));
		grouped.forEach((range, nums) -> System.out.println(range + " → " + nums));
		
		List<String>str=Arrays.asList("java", "api", "code", "spring");
		Map<Boolean, List<String>> evevOrOdd = str.stream().collect(Collectors.partitioningBy(st->st.length()%2==0));
		System.out.println("even -> "+ evevOrOdd.get(true));
		System.out.println("odd -> "+ evevOrOdd.get(false));

	}

}
