package sdbms;

import java.util.Scanner;

import custom_Exception.InvalidChoiceException;

public class Solution {

	public static void main(String[] args) {

		System.out.println("well come to Student Database");

		Scanner As=new Scanner(System.in);

		StudentManagementSystem sms=new StudentManagementSystemImpl();

		while(true) {

			System.out.println("01.AddStudent\n02.DisplayStudent\n03.DisplayAllStudent");
			System.out.println("04.RemoveStudent\n05.RemoveAllStudent\n06.UpdateStudent\n07.CountStudent");
			System.out.println("08.SortStudent\n09.GetStudentWithLowestMarks\n10.GetStudentWithHighestMarks\n11.Exit");
			System.out.println("Enter your choice");
			int ch=As.nextInt();
			
			switch(ch) {
			case 1: sms.addStudent();
			break;

			case 2: sms.displayStudent();
			break;

			case 3: sms.displayAllStudent();
			break;

			case 4: sms.removeStudent();
			break;

			case 5: sms.removeAllStudent();
			break;

			case 6: sms.updateStudent();
			break;

			case 7: sms.countStudent();
			break;

			case 8: sms.sortStudent();
			break;

			case 9: sms.getStudentWithLowestMarks();
			break;

			case 10:sms.getStudentWithHighestMarks();
			break;

			case 11:System.out.println("thank you");
			System.exit(0);

			default : 
				try { throw new InvalidChoiceException("choice is invalid");

				}
				catch(RuntimeException e) {
					System.out.println(e.getMessage());
				}
			}//end of switch
			System.out.println("============================");
		}//end while
	}//end of main
}//end of class
