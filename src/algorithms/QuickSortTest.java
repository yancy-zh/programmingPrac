package algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuickSortTest {
	Quicksort sol = new Quicksort();

	@Test
	void test1() {
		int[] toSort = { 8, 7, 2, 1, 0, 9, 6 };
		sol.quickSort(toSort, 0, 6);
		assertArrayEquals(toSort, new int[] { 0, 1, 2, 6, 7, 8, 9 });
	}

	@Test
	void test2() {
		int[] toSort = { 23, 87, 15, 6, 99, 64, 2, 75, 0 };
		sol.quickSort(toSort, 0, 6);
		assertArrayEquals(toSort, new int[] { 0, 1, 2, 6, 7, 8, 9 });
	}

}
