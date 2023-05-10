package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import algorithms.SearchInsertPosition;

public class searchInsertPositionTest
{
	@Test
	void targetIsFound()
	{
		assertEquals(SearchInsertPosition.searchInsert(new int[] { 1, 3, 5, 6 }, 5), 2);
	}
	
	@Test
	void targetIsInTheMiddle()
	{
		assertEquals(SearchInsertPosition.searchInsert(new int[] { 1, 3, 5, 6 }, 2), 1);
	}
	
	@Test
	void targetIsLargerThanTheLast()
	{
		assertEquals(SearchInsertPosition.searchInsert(new int[] { 1, 3, 5, 6 }, 7), 4);
	}
}
