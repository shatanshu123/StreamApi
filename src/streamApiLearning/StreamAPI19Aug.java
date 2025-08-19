package streamApiLearning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Staff {
	String name;
	String dept;

	Staff(String name, String dept) {
		this.name = name;
		this.dept = dept;
	}
}

public class StreamAPI19Aug {

	public static void main(String[] args) {
		List<Staff> employees = Arrays.asList(new Staff("Ravi", "IT"), new Staff("Amit", "HR"),
				new Staff("Neha", "Finance"), new Staff("Suresh", "IT"), new Staff("Rohan", "HR"));
		List<Worker> workers = Arrays.asList(new Worker("Ravi", 50000), new Worker("Amit", 80000),
				new Worker("Neha", 90000), new Worker("Rohan", 60000));
		List<String> word = Arrays.asList("Ram", "Shyam", "Sita", "Gopal", "Radha");
		long ans = word.stream().filter(n -> n.length() > 4).count();
		System.out.println(ans);

		List<String> words = Arrays.asList("apple", "bat", "banana", "kiwi");
		List<String> sort = words.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
		System.out.println(sort);

		List<String> wordss = Arrays.asList("apple", "banana", "apricot", "blueberry", "cherry");
		Map<Character, List<String>> group = wordss.stream()
				.collect(Collectors.groupingBy(wording -> wording.charAt(0)));
		System.out.println(group);

		List<Integer> number = Arrays.asList(10, 35, 27, 64, 18);
		int no = number.stream().max(Integer::compare).orElse(null);
		System.out.println(no);

		List<String> concat = Arrays.asList("Java", "Stream", "API");
		String join = concat.stream().collect(Collectors.joining());
		System.out.println(join);

		Map<String, Long> deptCount = employees.stream()
				.collect(Collectors.groupingBy(e -> e.dept, Collectors.counting()));
		System.out.println(deptCount);

		List<Integer> evenOrOdd = Arrays.asList(2, 4, 6, 8);
		boolean check = evenOrOdd.stream().allMatch(nos -> nos % 2 == 0);
		System.out.println(check);

		Worker secondHighest = workers.stream().sorted((e1, e2) -> Integer.compare(e2.salary, e1.salary)) // Desc order
				.skip(1) // Skip highest
				.findFirst() // Take 2nd
				.orElse(null);
		if (secondHighest != null)
			System.out.println(secondHighest.name + " (" + secondHighest.salary + ")");

		List<Integer> withOne = Arrays.asList(10, 15, 20, 25, 105, 210);
		List<Integer> result = withOne.stream().map(String::valueOf).filter(nn -> nn.startsWith("1"))
				.map(Integer::valueOf).collect(Collectors.toList());
		System.out.println(result);
		
		List<Integer>duplicate=Arrays.asList(5, 3, 5, 7, 9, 3, 1);
		List<Integer>duplicates = duplicate.stream().distinct().collect(Collectors.toList());
		System.out.println(duplicates);
	}
}
