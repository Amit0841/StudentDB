package com.college;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.college.DB.*;
import com.college.Dto.CollegeStu;

public class Ui {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int c=0;
do {
	System.out.println("1. Add Student");
	System.out.println("2. Update Student");
	System.out.println("3. Delete Student");
	System.out.println("4. Find Student By Id");
	System.out.println("5. Find By Skill");
	System.out.println("6. Find By Year");
	System.out.println("0. Exit");
	c=sc.nextInt();
	switch(c) {
	case 1:
	addStu(sc);
	break;
	case 2:
	upate(sc);
	break;
	case 3:
		delete(sc);
		break;
	case 4:
		find(sc);
		break;
	case 5:
		findSkill(sc);
		break;
	case 6:
		findByYear(sc);
		break;
		default:
			
			break;
	}
}while(c!=0);
sc.close();
	}

	private static void findByYear(Scanner sc) {
		System.out.println("Enter from Year");
		LocalDate yearFrom=LocalDate.parse(sc.next());
		System.out.println("Enter to Year");
		LocalDate yearTo=LocalDate.parse(sc.next());
		StuInterface s=new StudentInpl();
		try {
			List <CollegeStu> stu=s.findYear(yearFrom,yearTo);
			stu.forEach(System.out::println);
		} catch (SomeThingWentE | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void findSkill(Scanner sc) {
		System.out.println("Enter Skill");
		String skill=sc.next();
		StuInterface s=new StudentInpl();
		try {
			List <CollegeStu> stu=s.findSkill(skill);
			stu.forEach(System.out::println);
		} catch (SomeThingWentE | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void find(Scanner sc) {
		System.out.println("Enter Id");
		int id=sc.nextInt();
		StuInterface s=new StudentInpl();
		try {
			CollegeStu stu=s.findId(id);
			System.out.println(stu);
		} catch (SomeThingWentE | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void delete(Scanner sc) {
		System.out.println("Enter Id");
		int id=sc.nextInt();
		StuInterface s=new StudentInpl();
		try {
			s.deletStu(id);
			System.out.println("Delete success");
		} catch (SomeThingWentE | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void upate(Scanner sc)  {
		System.out.println("Enter Id");
		int id=sc.nextInt();
		System.out.println("Enter Name");
		String name=sc.next();
		System.out.println("Enter Year");
		String year=sc.next();
		System.out.println("Enter Join Date");
		LocalDate date=LocalDate.parse(sc.next());
		System.out.println("Enter Skill");
		String skill=sc.next();
		CollegeStu m=new CollegeStu(id,name,year,date,skill);
		
		StuInterface s=new StudentInpl();
		try {
			s.updateStu(m);
			System.out.println("Student update");
		} catch (SomeThingWentE | SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void addStu(Scanner sc) {

		System.out.println("Enter Name");
		String name=sc.next();
		System.out.println("Enter Year");
		String year=sc.next();
		System.out.println("Enter Join Date");
		LocalDate date=LocalDate.parse(sc.next());
		System.out.println("Enter Skill");
		String skill=sc.next();
		CollegeStu m=new CollegeStu(name,year,date,skill);
		
		StuInterface s=new StudentInpl();
		try {
			s.addStu(m);
			System.out.println("Student Added");
		} catch (SomeThingWentE | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
