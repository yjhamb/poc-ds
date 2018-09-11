package org.sai.poc.ds.misc;

import java.util.ArrayList;
import java.util.List;

public class Person {
	public enum Sex {
		MALE, FEMALE
	}

	private String name;
	private int age;
	private Sex gender;
	private String emailAddress;

	public Person(String name, int age, Sex gender, String emailAddress) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.emailAddress = emailAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", emailAddress=" + emailAddress + "]";
	}

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("John", 40, Sex.MALE, "john@xyz.com"));
		persons.add(new Person("Joe", 41, Sex.MALE, "joe@xyz.com"));
		persons.add(new Person("Jane", 42, Sex.FEMALE, "jane@xyz.com"));

		persons.parallelStream().filter(p -> p.getAge() > 41).map(p -> p.getEmailAddress())
				.forEach(email -> System.out.println(email));
	}

}
