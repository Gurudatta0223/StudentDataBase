package sdbms;

import java.util.ArrayList;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import coustom_sorting.SortStudentByAge;
import coustom_sorting.SortStudentById;
import coustom_sorting.SortStudentByMarks;
import coustom_sorting.SortStudentByName;
import custom_Exception.InvalidChoiceException;
import custom_Exception.StudentNotFoundException;

public class StudentManagementSystemImpl implements StudentManagementSystem{

	Scanner As=new Scanner(System.in);

	Map<String ,Student> db=new LinkedHashMap<String,Student>();


	public void addStudent() {

		System.out.println("Enter Student age");
		int age=As.nextInt();

		System.out.println("Enter Student name");
		String name=As.next();

		System.out.println("Enter Student marks");
		int marks=As.nextInt();

		Student s1=new Student(age,name,marks);

		db.put(s1.getId(), s1);

		System.out.println("Student record inserted sucessfully");

		System.out.println("Student id is:"+s1.getId());
	}


	public void displayStudent() {

		System.out.println("Enter the id to get details");
		String id=As.next();

		id=id.toUpperCase();//String id=

		if(db.containsKey(id)) {
			Student std=db.get(id);
			System.out.println("Age: "+std.getAge());
			System.out.println("Name: "+std.getName());
			System.out.println("Marks: "+std.getMarks());

			//	System.out.println("Student age is : "+db.get(id).getAge());
			//	System.out.println("Student name is : "+db.get(id).getName());
			//	System.out.println("Student marks is : "+db.get(id).getMarks());
		}
		else {
			try {
				String message="Student with the id "+id+" is not fount";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void displayAllStudent() {

		if(db.size()!=0) {
			Set<String> keys=db.keySet();//JSP101,JSP102,JSP103

			for(String key:keys) {
				Student value=db.get(key);
				System.out.println(value);
				//	System.out.println(db.get(key));
			}
		}
		else {
			try {
				String message="Student Records NOt Available to Display";
				throw new StudentNotFoundException(message);}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
	public void removeStudent() {

		System.out.println("Enter the id to remove");

		String id=As.next();
		id=id.toUpperCase();

		if(db.containsKey(id)) {
			System.out.println("Student record found ");
			System.out.println(db.get(id));//printing student id
			db.remove(id);
			System.out.println("Student record deleted success fully");

		}
		else {
			try {
				String message="Student with the id "+id+" not found";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void removeAllStudent() {
		if(db.size()!=0) {
			System.out.println("Student records available: "+db.size());
			db.clear();
			System.out.println("All Student record will deleted successfully......!!");
			System.out.println("Student records available: "+db.size());
			Student.count=101;

		}
		else {
			try {
				String message="Student DataBase is empty!!!!!";
				throw new StudentNotFoundException(message);}
			catch(Exception e) {
				System.out.println(e.getMessage());

			}
		}
	}
	public void updateStudent() {
		System.out.println("Enter the id to update");
		String id=As.next().toUpperCase();

		if(db.containsKey(id)) {
			Student std=db.get(id);

			System.out.println("1.UpdateAge\n2.UpdateName\n3.Updatemarks");
			System.out.println("Enter your choice");
			int ch=As.nextInt();

			switch(ch) {
			case 1:System.out.println("Enter the Age");
			int age=As.nextInt();		//std.setAge(As.nextInt());
			std.setage(age);	
			break;

			case 2:System.out.println("Enter the name");
			String name=As.next();
			std.setName(name);			//std.setName(As.next());
			break;

			case 3:System.out.println("Enter the Marks"); 
			int marks=As.nextInt();
			std.setMarks(marks);		//std.setMarks(As.nextInt());
			break;

			default :
				try {
					String message="choice is invalid";
					throw new InvalidChoiceException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {String message="Student id "+id+"not found";
			throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}


	}
	public void countStudent() {
		System.out.println("number of Student: "+db.size());
	}

	public void sortStudent() {

		if(db.size()>=2) {	

			Set<String> keys=db.keySet();
			List<Student> l=new ArrayList<>();

			for(String s:keys) {
				l.add(db.get(s));
			}

			System.out.println("1.Sort By Id\n2.Sort By Age\n3.Sort By Name\n4.Sort By Marks");

			int ch=As.nextInt();

			switch(ch) {
			case 1: Collections.sort(l,new SortStudentById());
			display(l);
			break;

			case 2: Collections.sort(l,new SortStudentByAge());
			display(l);
			break;

			case 3: Collections.sort(l,new SortStudentByName());
			display(l);
			break;

			case 4:Collections.sort(l,new SortStudentByMarks());
			display(l);
			break;

			default : System.out.println("enter valid choice");
			}
		}
	}

	private static void display(List<Student> l) {

		for(Student s:l) {
			System.out.println(s);
		}
	}


	public void getStudentWithLowestMarks() {

		if(db.size()>=2) {
			Set<String> keys=db.keySet();
			List<Student> l=new ArrayList<>();

			for(String s:keys) {
				l.add(db.get(s));
			}

			Collections.sort(l,new SortStudentByMarks());
			System.out.println(l.get(0));
		}
		else {
			try {
				String message="no sufficient object to compare";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public void getStudentWithHighestMarks() {

		if(db.size()>=2) {
			Set<String> keys=db.keySet();
			List<Student> l=new ArrayList<>();

			for(String s:keys) {
				l.add(db.get(s));}

			Collections.sort(l,new SortStudentByMarks());
			System.out.println(l.get(l.size()-1));
		}
		else {
			try {String message="no fufficient object to compare";
			throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}