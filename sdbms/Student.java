package sdbms;

public class Student {

	private String id;
	private int age;
	private String name;
	private int marks;
	static int count=101;

	public Student(int age,String name,int marks) {
		this.id="JSP"+count;
		this.age=age;
		this.name=name;
		this.marks=marks;
		count++;
	}

	public String getId() {
		return id;
	}

	public void setage(int age) {
		this.age=age;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name=name;	
	}

	public String getName() {
		return name;
	}

	public void setMarks(int marks) {
		this.marks=marks;
	}

	public int getMarks() {
		return marks;
	}

	public String toString() {
		return id+" "+age+" "+name+" "+marks;
	}

}
