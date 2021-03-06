package com.atmosware.testdemo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import com.atmosware.testdemo.business.common.exceptions.BusinessException;
import com.atmosware.testdemo.entities.concretes.Student;

public class StudentManager {
	
	public List<Student> students = new ArrayList<Student>();
	
	public StudentManager() {
		students.add(new Student(1,"Engin"));
		students.add(new Student(2,"Fatih"));
		students.add(new Student(3,"Orhan"));
		students.add(new Student(4,"Kıvanç"));
		students.add(new Student(5,"Burak Can"));
	}
	
	public void add(Student student) {
		
		checkIfStudentExists(student);
		students.add(student);
		
	}
	
	private void checkIfStudentExists(Student student) {
	for (Student  currentStudent : students) {
		if(currentStudent.getName()== student.getName()){
			throw new BusinessException("Bu öğrenci mevcut");
		  }
	     }
	    }
	   }
	
	//int add(Student)
	//Success : 1
	//Failure : 0


