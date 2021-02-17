package com.spring.orm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entites.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NumberFormatException, IOException
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao sd = context.getBean("studentDao",StudentDao.class);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		boolean go = true;
		while(go) {
			System.out.println("Press 1 to insert");
			System.out.println("Press 2 to get one");
			System.out.println("Press 3 to get all");
			System.out.println("Press 4 to delete");
			System.out.println("Press 5 to update");
			System.out.println("Press 6 to exit");
			System.out.println("Choose the option --------------------------");
			
			int input = Integer.parseInt(bf.readLine());
			
			switch(input) {
			case 1:
				System.out.println("Enter student id");
				int studentId = Integer.parseInt(bf.readLine());
				System.out.println("Enter student name");
				String studentName = bf.readLine();
				System.out.println("Enter student city");
				String studentCity = bf.readLine();
				Student s = new Student(studentId,studentName,studentCity);
				int i = sd.insert(s);
				System.out.println(i+"student added");
				break;
			case 2:
				System.out.println("Enter student id");
				studentId = Integer.parseInt(bf.readLine());
				s = sd.get(studentId);
				System.out.println("Student Id "+s.getStudentId());
				System.out.println("Student Name "+s.getStudentName());
				System.out.println("Student City"+s.getStudentCity());
				break;
			case 3:
				List<Student> allStudents = sd.getAll();
				for(Student std:allStudents) {
					System.out.println("Student Id "+std.getStudentId());
					System.out.println("Student Name "+std.getStudentName());
					System.out.println("Student City "+std.getStudentCity());
					System.out.println("_________________________________________________");
				}
				break;
			case 4:
				System.out.println("Enter student id");
				studentId = Integer.parseInt(bf.readLine());
				sd.delete(studentId);
				break;
			case 5:
				System.out.println("Enter id of the student to update and the new details");
				System.out.println("Enter student id");
				studentId = Integer.parseInt(bf.readLine());
				System.out.println("Enter student name");
				studentName = bf.readLine();
				System.out.println("Enter student city");
				studentCity = bf.readLine();
				s = new Student(studentId,studentName,studentCity);
				int a = sd.change(s);
				System.out.println("changed");
				break;
			case 6:
				go =false;
				break;
			}
			
			System.out.println("----------------------------------------------------");
		}
    }
}
