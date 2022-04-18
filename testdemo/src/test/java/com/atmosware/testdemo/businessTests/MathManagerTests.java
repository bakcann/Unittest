package com.atmosware.testdemo.businessTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.atmosware.testdemo.business.concretes.MathManager;

public class MathManagerTests {
	
	MathManager mathManager ;
	
	//MathManager mathManager = new MathManager(); buradada olabılır aşağıdada
		//mocking
	
	@BeforeEach
	public void setup() {
		mathManager = new MathManager();
	}
	
	@Test
	public void one_plus_seven_is_eight() {
		
		//arrange(lazım olan nesneye parametrelere ulaşırsın)  //given
		
		int number1=1;
		int number2= 7;
		int expected= 8;
		
		//act(actual gerçekleşen)   //when
		int actual = mathManager.add(number1, number2);
		
		//assert(expected ile actual doğrulugunu test et)  //then
		Assertions.assertEquals(expected, actual);
		
	}
	
	@Test
	public void minus_one_plus_seven_is_six() {
		
		//arrange(lazım olan nesneye parametrelere ulaşırsın)  //given
		
		int number1=-1;
		int number2= 7;
		int expected= 6;
		
		
		//act(actual gerçekleşen)   //when
		int actual = mathManager.add(number1, number2);
		
		//assert(expected ile actual doğrulugunu test et)  //then
		Assertions.assertEquals(expected, actual);
		
	}
	@ParameterizedTest
	@ValueSource(ints = {2,5,8})   //@CsvSource({2,4},{2,4},{2,4})
	public void multiply_with_zero_should_return_zero(int sourceItem) {
		int number1 = 0;
		int number2 = sourceItem;
		int expected = 0;
		
		int actual = mathManager.multiply(number1, number2);
		
		Assertions.assertEquals(expected, actual);
		
	}

}
