package com.atmosware.testdemo.businessTests;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.atmosware.testdemo.business.common.exceptions.BusinessException;
import com.atmosware.testdemo.business.concretes.StudentManager;
import com.atmosware.testdemo.entities.concretes.Student;

public class StudentManagerTests {
	StudentManager manager;
	
	@BeforeEach //çok kullanılır. Testlşerden önce çalışır
	public void setup() {
		manager = new StudentManager();
	}
	
	@AfterEach //temizleme için kullalanılır testlerden sonra çalışır ama az kullanılır
	public void cleanup() {
		
	}
	
	@BeforeAll  //bir kez çalışır  bazen kullanılır
	public void initialize() {
		
	}
	
	@AfterAll // çok çok az kullanılır   tüm testler ortak baglantı kullanıyodur kapatmak için kullanılır
	public void finish() {
		
	}
	
	@Test
	public void student_can_not_be_duplicated_by_name1() {
		
		
		Student student = new Student();
		student.setId(6);
		student.setName("Engin");
		
		Executable executable = () -> manager.add(student);
		
		Assertions.assertThrows(BusinessException.class, executable);
		
	}
	
	@Test
	public void student_can_not_be_duplicated_by_name2() {
		
		
		Student student = new Student();
		student.setId(6);
		student.setName("Fatih");
		
		Executable executable = () -> manager.add(student);
		
		Assertions.assertThrows(BusinessException.class, executable);
		
	}
	
	

}
