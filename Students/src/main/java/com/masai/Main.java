package com.masai;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

import java.time.LocalDate;
import java.util.*;
public class Main {
static EntityManagerFactory emf;
static{
	emf=Persistence.createEntityManagerFactory("stu_connect");
}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int c=0;
do {
	System.out.println("1. Add Student");
	System.out.println("2. Update Student");
	System.out.println("3. Delete Student");
	System.out.println("4. Find Student By Id");
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
		default:
			System.out.println("Wrong input");
			break;
	}
}while(c!=0);
sc.close();
	}
	
	private static void find(Scanner sc) {
		System.out.println("Enter Id");
		int id=sc.nextInt();
		findStu(id);
		
	}

	private static void findStu(int id) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		MasaiStudent m= em.find(MasaiStudent.class, id);
		if(m!=null) {
			System.out.println("Id :"+m.getId()+", name :"+m.getName()+", unit"+m.getUnit()  +", Join Date:"+m.getJoinDate() +", Skill:"+m.getSkill());
		}else {
			System.out.println("Id not found!");
		}
			em.close();
		
	}

	private static void delete(Scanner sc) {
		System.out.println("Enter Id");
		int id=sc.nextInt();
		deleteStu(id);
	}

	private static void deleteStu(int id) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		MasaiStudent m= em.find(MasaiStudent.class, id);
		if(m!=null) {
			et.begin();
			em.remove(m);
			et.commit();
		}else {
			System.out.println("Id not found!");
		}
			em.close();
		
	}

	private static void upate(Scanner sc) {
		System.out.println("Enter Id");
		int id=sc.nextInt();
		System.out.println("Enter Unit");
		String unit=sc.next();
		updateStu(id,unit);
	}

	private static void updateStu(int id, String unit) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		MasaiStudent m= em.find(MasaiStudent.class, id);
		if(m!=null) {
			et.begin();
			m.setUnit(unit);
			et.commit();
		}else {
			System.out.println("Id not found!");
		}
			em.close();
		
		
	}

	private static void addStu(Scanner sc) {
		
		System.out.println("Enter Name");
		String name=sc.next();
		System.out.println("Enter Unit");
		String unit=sc.next();
		System.out.println("Enter Join Date");
		LocalDate date=LocalDate.parse(sc.next());
		System.out.println("Enter Skill");
		String skill=sc.next();
		MasaiStudent m=new MasaiStudent(name,unit,date,skill);
		addStudent(m);
	}
	private static void addStudent(MasaiStudent m) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		try {
			et.begin();
			em.persist(m);
			et.commit();
		}catch(PersistenceException e ) {
			System.out.println(e);
		}
		finally {
			em.close();
		}
	}

}
