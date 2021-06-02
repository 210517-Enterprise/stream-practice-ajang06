package com.revature.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.revature.models.Address;
import com.revature.models.MobileNumber;
import com.revature.models.Student;
import com.revature.models.TempStudent;

public class StreamTest {

	public static void main(String[] args) {

		/*
		 * ============== Don't alter the code between lines 24 - 42 ==============
		 */

		Student student1 = new Student("Bob", 20, new Address("1234"),
				Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

		Student student2 = new Student("Alice", 20, new Address("1235"),
				Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

		Student student3 = new Student("Wally", 20, new Address("1236"),
				Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

		List<Student> students = Arrays.asList(student1, student2, student3);

		/*
		 * ========== Don't alter the code above (lines 24 - 42) ===============
		 */

		/***************************************************************************
		 * (1) Get the student with the name "Bob" and print his name to the console. If
		 * "Bob" does not exist, print "No student found".
		 ****************************************************************************/
		System.out.println("******PROBLEM 1******");
		List<Student> s1 = students.stream().filter(student -> student.getName().equals("Bob"))
				.collect(Collectors.toList());
		System.out.println(s1.isEmpty() ? "No student found" : s1.get(0).getName());

		/***************************************************************************
		 * (2) Get the student with matching address "1235" and print their name to the
		 * console. If the address does not exist, print "No student found". HINT: Save
		 * students.stream()...etc to an Optional<Student> in the case that the student
		 * doesn't exist. Resource: https://www.geeksforgeeks.org/java-8-optional-class/
		 ****************************************************************************/
		System.out.println("\n******PROBLEM 2******");
		List<Student> s2 = students.stream().filter(student -> student.getAddress().getZipcode().equals("1235"))
				.collect(Collectors.toList());
		if (s2.isEmpty()) {
			System.out.println("No student found");
		} else {
			s2.forEach(Student -> System.out.println(Student.getName()));
		}

		/****************************************************************************
		 * (3) Get all the students that have the mobile number "3333" and print their
		 * names to the console.
		 *****************************************************************************/
		System.out.println("\n******PROBLEM 3******");
		List<Student> s3 = students.stream()
				.filter(s -> s.getMobileNumbers().stream().anyMatch(x -> Objects.equals(x.getNumber(), "3333")))
				.collect(Collectors.toList());

		String r3 = s3.stream().map(s -> s.getName()).collect(Collectors.joining("\n"));

		System.out.println(r3);

		/***************************************************************************
		 * (4) Get all student having mobile number "1233" and "1234" and print their
		 * names to the console.
		 ***************************************************************************/
		System.out.println("\n******PROBLEM 4******");
		List<Student> s4 = students.stream()
				.filter(s -> s.getMobileNumbers().stream()
						.allMatch(x -> Objects.equals(x.getNumber(), "1233") || Objects.equals(x.getNumber(), "1234")))
				.collect(Collectors.toList());

		String r4 = s4.stream().map(s -> s.getName()).collect(Collectors.joining("\n"));

		System.out.println(r4);

		/***************************************************************************
		 * (5) Create a List<Student> from the List<TempStudent>. Call it studentList.
		 * Hint: Use Collectors.toList(). Print it to the console. Resource:
		 * https://www.geeksforgeeks.org/collectors-tolist-method-in-java-with-examples/
		 ****************************************************************************/
		TempStudent tmpStud1 = new TempStudent("Bob1", 201, new Address("12341"),
				Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));

		TempStudent tmpStud2 = new TempStudent("Alice1", 202, new Address("12351"),
				Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));

		List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);

		System.out.println("\n******PROBLEM 5******");
		List<Student> studentList = tmpStudents.stream()
				.map(tmpstds -> new Student(tmpstds.name,tmpstds.age,tmpstds.address,tmpstds.mobileNumbers))
				.collect(Collectors.toList());
		
		System.out.println(studentList);

		/***************************************************************************
		 * (6) Convert the List<Student> called studentList that you made in question
		 * (5) to List<String> of just their names. Call this new list "studentNames".
		 * Print it to the console.
		 ****************************************************************************/

		System.out.println("\n******PROBLEM 6******");
		
		List<String> studentNames = studentList.stream()
				.map(s -> s.getName())
				.collect(Collectors.toList());
		System.out.println(studentNames);

		/***************************************************************************
		 * (7) Convert List<Students> to a single String called name with just their
		 * names. Print that String to the console.
		 ****************************************************************************/

		System.out.println("\n******PROBLEM 7******");
		
		String name = studentNames.stream()
				.map(s -> s.toString())
				.collect(Collectors.joining(", "));
		System.out.println(name);

		/****************************************************************************
		 * (8) Change all the Strings within the List<String> nameList to Upper Case.
		 * Print it to the screen.
		 *****************************************************************************/
		List<String> nameList = Arrays.asList("Bob", "Danny", "Alice", "Eddie", "Cathy");

		System.out.println("\n******PROBLEM 8******");
		List<String> upper = nameList.stream()
				.map(s -> s.toUpperCase())
				.collect(Collectors.toList());
		
		System.out.println(upper);

		/****************************************************************************
		 * (9) Sort List<String> namesList by natural order. Hint: Research .sorted()
		 * method
		 * https://www.geeksforgeeks.org/stream-sorted-in-java/#:~:text=Stream%20sorted()%20returns%20a,streams%2C%20no%20stability%20is%20guaranteed.
		 *****************************************************************************/
		List<String> namesList = Arrays.asList("Bob", "Danny", "Alice", "Eddie", "Cathy");

		System.out.println("\n******PROBLEM 9******");
		List<String> natOrder = namesList.stream()
				.sorted()
				.collect(Collectors.toList());
		
		System.out.println(natOrder);
	}

}
