package hsbcMock;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SortEvenOddTest {

	@Test
	void test1() {
		int[] nums = { 4, 1, 2, 3 };
		SortEvenOdd sol = new SortEvenOdd();
		assertArrayEquals(new int[] { 2, 3, 4, 1 }, sol.sortEvenOdd(nums));
	}

	@Test
	void test2() {
		int[] nums = { 4, 1, 3, 3, 2, 5, 1 };
		SortEvenOdd sol = new SortEvenOdd();
		assertArrayEquals(new int[] { 1, 5, 2, 3, 3, 1, 4 }, sol.sortEvenOdd(nums));
	}

}
