package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import algorithms.SnakeInMatrix;

class testSnakeOutput
{
	SnakeInMatrix obj = new SnakeInMatrix();
	
	@Test
	void test1()
	{
		int temp = obj.finalPositionOfSnake(2, new ArrayList<String>(Arrays.asList("RIGHT", "DOWN")));
		assertEquals(3, temp);
	}
	
	@Test
	void test2()
	{
		int temp = obj.finalPositionOfSnake(2, new ArrayList<String>(Arrays.asList("DOWN", "RIGHT", "UP")));
		assertEquals(1, temp);
	}
}
