package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import algorithms.Intersection;

class IntersectionTest
{
	
	@Test
	void equalLengthArraytest()
	{
		Intersection intersection = new Intersection();
		assertArrayEquals(intersection.findIntersection(new int[] { 2, 2 }, new int[] { 2, 2 }), new int[] { 2, 2 });
	}
	@Test
	void oneIsSubsetOfTheOtherTest()
	{
		Intersection intersection = new Intersection();
		assertArrayEquals(intersection.findIntersection(new int[] { 2, 2, 1, 1 }, new int[] { 2, 2 }), new int[] { 2, 2 });
	}
	@Test
	void partOfTwoSetsIntersectTest()
	{
		Intersection intersection = new Intersection();
		assertArrayEquals(intersection.findIntersection(new int[] { 2, 2, 1, 1 }, new int[] { 2, 2, 3, 3}), new int[] { 2, 2 });
	}
	
}
