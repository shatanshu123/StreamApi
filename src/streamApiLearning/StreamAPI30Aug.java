package streamApiLearning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI30Aug {
	public static boolean isPrime(int n) {
		if(n<=1)return false;
		return IntStream.rangeClosed(2, (int)Math.sqrt(n)).noneMatch(i->n%i==0);
	}

	public static void main(String[] args) {
		String str = "I love Java streams";
		long ans = Arrays.stream(str.split(" ")).count();
		System.out.println(ans);

		List<String> animals = Arrays.asList("apple", "bat", "car", "elephant", "dog");
		Map<Integer, List<String>> answer = animals.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(answer);

		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(3, 4, 5);
		List<Integer> l = Stream.concat(list1.stream(), list2.stream()).distinct().collect(Collectors.toList());
		System.out.println(l);

		List<List<Integer>> input = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));
		List<Integer> output = input.stream().flatMap(List::stream).collect(Collectors.toList());
		System.out.println(output);

		List<Integer> list3 = Arrays.asList(5, 3, 9, 7, 9, 2);
		long no = list3.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1);
		System.out.println(no);

		Map<String, Integer> map = new HashMap<>();
		map.put("a", 2);
		map.put("b", 5);
		map.put("c", 1);

		// Sort by values in descending order
		Map<String, Integer> sortedMap = map.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, // merge function (not
																									// needed here)
						LinkedHashMap::new // preserve insertion order
				));
		System.out.println(sortedMap);
		
		 List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8);
		 Map<Boolean, List<Integer>> partitioned = numbers.stream()
					.collect(Collectors.partitioningBy(StreamAPI30Aug::isPrime));
		 System.out.println("Prime -> "+partitioned.get(true));
		 System.out.println("Non Prime -> "+partitioned.get(false));

	}

	
	

}
