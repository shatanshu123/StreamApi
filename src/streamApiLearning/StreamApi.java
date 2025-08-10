package streamApiLearning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApi {
	public class TestMain {
		
		public static void main(String[] args) {
	        List<String> words = Arrays.asList("Apple", "Avocado", "Banana", "Blueberry", "Cherry");
	            List<String>rr = words.stream()
	            		.filter(n->n.startsWith("B")).collect(Collectors.toList());
				List<String> res = words.stream().map(String::toUpperCase)
						.collect(Collectors.toList());
				Map<Character,List<String>>res1=words.stream()
						.collect(Collectors.groupingBy(word->word.charAt(0)));
				Optional<String> res2= words.stream().min(Comparator.comparingInt(String::length));
				System.out.println(res);
				System.out.println(res1);
				System.out.println(rr);
				System.out.println(res2.orElse("-1"));
				List<Integer>ll=Arrays.asList(2, 3,2, 4,12,13,15);
				 Set<Integer> res11=ll.stream().
						 collect(Collectors.toSet());
				 Optional<Integer> rm=ll.stream().distinct().reduce((a,b)->a*b);
				System.out.println(res11);
				System.out.println(rm.orElse(-1));

		}
		

		
	}
}
