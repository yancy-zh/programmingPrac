package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import algorithms.PlusOne;
import org.junit.jupiter.api.Test;

class PlusOneTest
{
	
	@Test
	void lastDigitUnderNineTest()
	{
		assertArrayEquals(new int[] { 1, 2, 4 }, PlusOne.plusOne(new int[] { 1, 2, 3 }));
	}
	
	@Test
	void lastIntTest()
	{
		assertArrayEquals(new int[] { 4, 3, 2, 2 }, PlusOne.plusOne(new int[] { 4, 3, 2, 1 }));
	}
	
	@Test
	void lastTwoDigitNineTest()
	{
		assertArrayEquals(new int[] { 1, 0, 0 }, PlusOne.plusOne(new int[] { 9, 9 }));
	}
}
