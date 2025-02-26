package hsbcMock;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class TopKFrequentTest {

	@Test
	void test1() {
		int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		TopKFrequent sol = new TopKFrequent();
		int[] actual = sol.topKFrequent1(nums, k);
		Arrays.sort(actual);
		assertArrayEquals(new int[] { 1, 2 }, actual);
	}

	@Test
	void test2() {
		int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		TopKFrequent sol = new TopKFrequent();
		int[] actual = sol.topKFrequent2(nums, k);
		Arrays.sort(actual);
		assertArrayEquals(new int[] { 1, 2 }, actual);
	}
}
