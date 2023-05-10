package test;

import org.junit.jupiter.api.Test;

import algorithms.SetZeros;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;

public class TestSetZeros
{
	SetZeros tempSetZeros = new SetZeros();
	
	@Test
	void singleValueTest()
	{
		
		int[][] mat = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		int[][] res = { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
		Assert.assertArrayEquals(tempSetZeros.setZeroes(mat), res);
	};
	
	@Test
	void multiZeroTest()
	{
		int[][] mat = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		int[][] res = { { 0, 0, 0, 0 }, { 0, 4, 5, 0 }, { 0, 3, 1, 0 } };
		Assert.assertArrayEquals(tempSetZeros.setZeroes(mat), res);
	};
}
