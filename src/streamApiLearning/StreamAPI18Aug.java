package streamApiLearning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Emp {
	String name;
	String dept;

	Emp(String name, String dept) {
		this.name = name;
		this.dept = dept;
	}

	public String getDept() {
		return dept;
	}
}

class Employee {
	int id;
	String name;
	double salary;

	Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}
}
class Worker {
    String name;
    int salary;

    Worker(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return name + " (" + salary + ")";
    }
}


public class StreamAPI18Aug {
	private static boolean isPrime(int number) {
		if (number <= 1)
			return false;
		return IntStream.rangeClosed(2, (int) Math.sqrt(number)).allMatch(i -> number % i != 0);
	}

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee(1, "Ravi", 50000), new Employee(2, "Amit", 60000),
				new Employee(3, "Suresh", 55000));
		List<Emp> emps = Arrays.asList(new Emp("Ravi", "IT"), new Emp("Amit", "HR"), new Emp("Suresh", "IT"),
				new Emp("Neha", "Finance"), new Emp("Rohan", "HR"));
		 List<Worker> workers = Arrays.asList(
		            new Worker("Ravi", 50000),
		            new Worker("Amit", 80000),
		            new Worker("Suresh", 75000),
		            new Worker("Neha", 90000),
		            new Worker("Rohan", 60000)
		        );
		List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		List<Integer> number = num.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println(number);

		List<String> list = Arrays.asList("", " ", "Java", "Stream", "API");
		String lists = list.stream().map(String::trim).filter(s -> !s.isEmpty()).findFirst().orElse("No");
		System.out.println(lists);

		List<String> sortedNames = employees.stream().sorted(Comparator.comparing(Employee::getName)) // sort by name
				.map(Employee::getName) // extract only names
				.collect(Collectors.toList());
		System.out.println(sortedNames);

		Employee maxSalaryEmp = employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).orElse(null);
		if (maxSalaryEmp != null) {
			System.out.println(maxSalaryEmp.getName() + " (" + maxSalaryEmp.getSalary() + ")");
		}

		Map<String, Long> ee = emps.stream().collect(Collectors.groupingBy(Emp::getDept, Collectors.counting()));
		System.out.println(ee);

		List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
		Map<Boolean, List<Integer>> partitioned = numbers.stream()
				.collect(Collectors.partitioningBy(StreamAPI18Aug::isPrime));
		System.out.println("Prime -> " + partitioned.get(true));
		System.out.println("Non-Prime -> " + partitioned.get(false));
		
		 List<Worker> top3 =workers.stream().sorted(Comparator.comparingInt((Worker w)->w.salary).reversed()).limit(3).collect(Collectors.toList());
		 top3.forEach(System.out::println);
		 
		 List<String>words = Arrays.asList("Java", "SpringBoot", "Microservices", "API");
		 String l = words.stream().max(Comparator.comparing(String::length)).orElse("no");
		 System.out.println(l);
		 
		 List<String>word = Arrays.asList("Java", "Spring", "Hibernate", "Docker");
		 String wordss = word.stream().collect(Collectors.joining(","));
		 System.out.println(wordss);
	
	}
}
