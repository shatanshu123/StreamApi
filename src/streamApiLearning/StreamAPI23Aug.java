package streamApiLearning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamAPI23Aug {

	public static void main(String[] args) {
		String words = "Java streams make coding elegant";
		String ans = Arrays.stream(words.split(" ")).max((a,b)->Integer.compare(a.length(), b.length())).orElse("");
		System.out.println(ans);
		
		List<Integer>number = Arrays.asList(1,2,2,3,4,5,1,6,7,5);
		Set<Integer>hash=new HashSet<>();
		List<Integer>val = number.stream().filter(n->!hash.add(n)).sorted().collect(Collectors.toList());
		System.out.println(val);
		
		List<String>word = Arrays.asList("Ravi", "Jonathan", "Amit", "Christopher");
		String key = word.stream().max(Comparator.comparing(String::length)).orElse("");
		System.out.println(key);
		
		List<Integer>nums=Arrays.asList(2, 3, 6);
		boolean check = nums.stream().allMatch(n->n%2==0);
		System.out.println(check);
		
		List<Integer>asc=Arrays.asList(7, 2, 10, 4, 6);
		int n =asc.stream().sorted().skip(1).findFirst().orElse(-1);
		System.out.println(n);
		
		List<String>fruits = Arrays.asList("apple", "banana", "avocado", "blueberry", "cherry");
		Map<Character, List<String>>map=fruits.stream().collect(Collectors.groupingBy(w->w.charAt(0)));
		System.out.println(map);
		
		List<String>program = Arrays.asList("Java", "Stream", "API");
		String pro = program.stream().collect(Collectors.joining("-"));
		System.out.println(pro);
	}

}
