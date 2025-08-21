package streamApiLearning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Workering {
	String name;
	double salary;

	Workering(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public String getName() {
		return name;
	}
}

public class StreamAPI21Aug {

	public static void main(String[] args) {
		List<Workering> employees = Arrays.asList(new Workering("Ravi", 50000), new Workering("Amit", 80000),
				new Workering("Neha", 90000));
		double avg = employees.stream().collect(Collectors.averagingDouble(Workering::getSalary));
		System.out.println(avg);
		
		List<String>words = Arrays.asList("Java", "Spring", "Stream");
		String join = words.stream().collect(Collectors.joining(","));
		System.out.println(join);
		
		List<Integer>number = Arrays.asList(5, 2, 8, 1, 3);
		Integer ans =number.stream().sorted().skip(1).findFirst().orElse(-1);
		System.out.println(ans);
		
		String word = "stream api examples";
		long count = word.chars().mapToObj(c->(char)c).filter(ch-> "aeiou".indexOf(ch)!=-1).count();
		System.out.println(count);
		
		Set<String> set = new HashSet<>();
		List<String>list = Arrays.asList("apple", "banana", "apple", "orange", "banana");
		List<String>listAns =list.stream().filter(s->!set.add(s)).collect(Collectors.toList());
		System.out.println(listAns);
		
		 List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		 Map<String, List<Integer>> grouped =numbers.stream().collect(Collectors.groupingBy(n-> n%2==0 ? "Even":"Odd"));
		 grouped.forEach((k,v)->System.out.println(k + "-> "+ v));
		 
		 String str = "success";

	        Map.Entry<Character, Long> result = str.chars()
	                .mapToObj(c -> (char) c)
	                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
	                .entrySet()
	                .stream()
	                .max(Map.Entry.comparingByValue())
	                .orElseThrow();

	        System.out.println(result.getKey() + " (appears " + result.getValue() + " times)");
		 
		 List<String>palindrome = Arrays.asList("level", "apple", "banana", "madam", "racecar", "java");
		String pali = palindrome.stream().filter(st->st.equals(new StringBuilder(st).reverse().toString()))
		 .max(Comparator.comparingInt(String::length)).orElse(null);
		System.out.println(pali);
		 
		 List<Integer>diff = Arrays.asList(15, 3, 27, 9, 42, 18);
		int difference = diff.stream().max(Integer::compareTo).get()-diff.stream().min(Integer::compareTo).get();
		 System.out.println(difference);
		 
		 List<Integer> lists = Arrays.asList(1, 2, 3, 2, 1);

	        boolean isPalindrome = IntStream.range(0, lists.size() / 2)
	                .allMatch(i -> lists.get(i).equals(lists.get(lists.size() - i - 1)));

	        System.out.println(isPalindrome); 
		 
	        String sentence = "I love Java and I love coding";

	        String results = Arrays.stream(sentence.split(" "))
	                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // word -> frequency
	                .entrySet()
	                .stream()
	                .filter(entry -> entry.getValue() == 1)   // keep only non-repeated
	                .map(Map.Entry::getKey)                  // extract the word
	                .findFirst()                             // take the first one
	                .orElse(null);

	        System.out.println(results);
		 
		 
	}

}
