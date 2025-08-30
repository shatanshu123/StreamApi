package streamApiLearning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamAPI17Aug {
	static class Employee {
		private String name;

		@Override
		public String toString() {
			return "Employee [name=" + name + ", salary=" + salary + "]";
		}

		private int salary;

		public Employee(String name, int salary) {
			this.name = name;
			this.salary = salary;
		}

		public int getSalary() {
			return salary;
		}
	}

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee("Alice", 5000), new Employee("Bob", 7000),
				new Employee("Charlie", 6000));
		double avg = employees.stream().mapToInt(Employee::getSalary).average().orElse(-1);
		System.out.println(avg);

		List<String> words = Arrays.asList("java", "springboot", "sql", "angular");
		String ans = words.stream().max(Comparator.comparingInt(String::length)).orElse("not this time");
		System.out.println(ans);

		List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6);
		Map<Boolean, List<Integer>> anss = num.stream().collect(Collectors.groupingBy(n -> {
			if (n % 2 == 0)
				return true;
			else
				return false;
		}));
		System.out.println(anss);

		List<String> word = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
		Map<String, Long> word1 = word.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()));
		System.out.println(word1);

		List<Integer> nums = Arrays.asList(1, 2, 3, 2, 4, 1);
		Set<Integer> nums1 = nums.stream().collect(Collectors.toSet());
		System.out.println(nums1);

		String input = "programming";
		List<Character> inputs = input.chars().mapToObj(c -> (char) c).distinct().collect(Collectors.toList());
		System.out.println(inputs);

		List<Employee> greater = employees.stream().filter(n -> n.getSalary() > avg).collect(Collectors.toList());
		System.err.println(greater);

		List<Integer> three = employees.stream().map(Employee::getSalary).sorted(Comparator.reverseOrder()).limit(3)
				.collect(Collectors.toList());
		System.out.println(three);

		List<Employee> threefull = employees.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed())
				.limit(3).collect(Collectors.toList());
		System.out.println(threefull);

		Map<Boolean, List<Employee>> partitioned = employees.stream()
				.collect(Collectors.partitioningBy(n -> n.getSalary() > 6000));
		System.out.println(partitioned);

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 5, 1, 6, 3);
		Set<Integer> hashNumbers = new HashSet<>();
		List<Integer> duplicates = numbers.stream().filter(q -> !hashNumbers.add(q)).distinct()
				.collect(Collectors.toList());
		System.out.println(duplicates);
		
		List<String>fruits = Arrays.asList("Apple", "Banana", "Avocado", "Blueberry");
		Map<Boolean, List<String>>answer=fruits.stream().collect(Collectors.partitioningBy(n->n.charAt(0)=='A'));
		System.out.println("A -> "+ answer.get(true));
		System.out.println("B -> "+ answer.get(false));
		Map<String, Long>answer1=fruits.stream().collect(Collectors.groupingBy(w->w,Collectors.counting()));
		System.out.println(answer1);
		List<String>fruit  = fruits.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
		System.out.println(fruit);
		
	}
}
