package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import algorithms.MissingNumber;

class MissingNumberTest
{
	
	@Test
	void missingInTheLeftHalftest()
	{
		assertEquals(MissingNumber.missingNumber(new int[] {0, 1, 2, 4, 5, 6, 7}), 3);
	}
	
}
