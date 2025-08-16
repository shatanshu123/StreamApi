package streamApiLearning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamAPI16Aug {

	static class Employee {
		private int id;
		private String name;
		private int Salary;
		private String dept;

		@Override
		public String toString() {
			return "Employee [ name=" + name + ", Salary=" + Salary + "]";
		}

		public Employee(int id, String name) {
			this.id = id;
			this.name = name;

		}

		public Employee(int id, int Salary) {
			this.id = id;
			this.Salary = Salary;

		}

		public Employee(String name, int Salary) {
			this.name = name;
			this.Salary = Salary;

		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public int getSalary() {
			return Salary;
		}

		public Employee(String name, String dept) {
			this.name = name;
			this.dept = dept;
		}

		public String getDept() {
			return dept;
		}

//		@Override
//		public String toString() {
//			return "{name: \"" + name + "\", dept: \"" + dept + "\"}";
//		}
	}

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee(1, "Alice"), new Employee(2, "Bob"),
				new Employee(3, "Charlie"));
		List<Employee> emplo = Arrays.asList(new Employee("Alice", 5000), new Employee("Brown", 7000),
				new Employee("Charlie", 5000));
		Map<Integer, String> map = employees.stream().collect(Collectors.toMap(Employee::getId, Employee::getName));
		System.out.println(map);

		List<Employee> sortedEmployees = emplo.stream()
				.sorted(Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getName))
				.collect(Collectors.toList());

		System.out.println(sortedEmployees);

		List<String> name = emplo.stream().filter(n -> n.getName().startsWith("A")).map(Employee::getName)
				.collect(Collectors.toList());
		System.out.println(name);

		Optional<Employee> sortEmp = emplo.stream().max(Comparator.comparing(Employee::getSalary));
		System.out.println(sortEmp.orElse(null));

		List<Employee> employeess = Arrays.asList(new Employee("Alice", "IT"), new Employee("Bob", "HR"),
				new Employee("Charlie", "IT"));
		Map<String, List<Employee>> groupedByDept = employeess.stream()
				.collect(Collectors.groupingBy(Employee::getDept));
		System.out.println(groupedByDept);
		Map<String, Long> groupedByDeptCount = employeess.stream()
				.collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
		System.out.println(groupedByDeptCount);

		List<Employee> sortedEmployeesSec = emplo.stream()
				.sorted(Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getName))
				.collect(Collectors.toList());

		List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5));
        System.out.println(listOfLists);
		List<Integer>lists = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(lists);
	}

}
