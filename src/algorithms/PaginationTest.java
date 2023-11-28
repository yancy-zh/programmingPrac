package algorithms;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class PaginationTest
{
	@Test
	void testGetPaginated1()
	{
		List<Integer> lsOfIntegers = new ArrayList<>();
		lsOfIntegers.add(1);
		lsOfIntegers.add(1);
		lsOfIntegers.add(1);
		lsOfIntegers.add(2);
		lsOfIntegers.add(2);
		lsOfIntegers.add(2);
		lsOfIntegers.add(3);
		lsOfIntegers.add(3);
		lsOfIntegers.add(3);
		lsOfIntegers.add(4);
		lsOfIntegers.add(4);
		lsOfIntegers.add(4);
		
		Pagination<Integer> myPagination = new Pagination<>(lsOfIntegers);
		assertEquals(myPagination.getPaginated(1), Arrays.asList(1, 1, 1));
	}
	
	@Test
	void testGetPaginated2()
	{
		List<Integer> lsOfIntegers = new ArrayList<>();
		lsOfIntegers.add(1);
		lsOfIntegers.add(1);
		lsOfIntegers.add(1);
		lsOfIntegers.add(2);
		lsOfIntegers.add(2);
		lsOfIntegers.add(2);
		lsOfIntegers.add(3);
		lsOfIntegers.add(3);
		lsOfIntegers.add(3);
		lsOfIntegers.add(4);
		lsOfIntegers.add(4);
		lsOfIntegers.add(4);
		
		Pagination<Integer> myPagination = new Pagination<>(lsOfIntegers);
		assertEquals(myPagination.getPaginated(2), Arrays.asList(2, 2, 2));
	}
	
	@Test
	void testGetPaginated3()
	{
		List<Integer> lsOfIntegers = new ArrayList<>();
		lsOfIntegers.add(1);
		lsOfIntegers.add(1);
		lsOfIntegers.add(1);
		lsOfIntegers.add(2);
		lsOfIntegers.add(2);
		lsOfIntegers.add(2);
		lsOfIntegers.add(3);
		lsOfIntegers.add(3);
		lsOfIntegers.add(3);
		lsOfIntegers.add(4);
		lsOfIntegers.add(4);
		lsOfIntegers.add(4);
		
		Pagination<Integer> myPagination = new Pagination<>(lsOfIntegers);
		assertEquals(myPagination.getPaginated(3), Arrays.asList(3, 3, 3));
	}
	
	@Test
	void testGetPaginated4()
	{
		List<Integer> lsOfIntegers = new ArrayList<>();
		lsOfIntegers.add(1);
		lsOfIntegers.add(1);
		lsOfIntegers.add(1);
		lsOfIntegers.add(2);
		lsOfIntegers.add(2);
		lsOfIntegers.add(2);
		lsOfIntegers.add(3);
		lsOfIntegers.add(3);
		lsOfIntegers.add(3);
		lsOfIntegers.add(4);
		lsOfIntegers.add(4);
		lsOfIntegers.add(4);
		
		Pagination<Integer> myPagination = new Pagination<>(lsOfIntegers);
		assertEquals(myPagination.getPaginated(4), Arrays.asList(4, 4, 4));
	}
	
}
