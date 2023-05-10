package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import algorithms.Sqrt;
public class sqrtTest
{
	@Test
	void normalSituationTest() {
		Sqrt temp = new Sqrt();
		assertEquals(temp.mySqrt(4), 2); 
	}
	
	@Test
	void abnormalSituationTest1() {
		Sqrt temp = new Sqrt();
		assertEquals(temp.mySqrt(6), 2); 
	}
	
	@Test
	void abnormalSituationTest2() {
		Sqrt temp = new Sqrt();
		assertEquals(temp.mySqrt(2147395600), 46340); 
	}
}
