package hsbcMock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LargestConsecutiveSequenceTest {

	@Test
	void test1() {
		int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
		LargestConsecutiveSequence sol = new LargestConsecutiveSequence();
		assertEquals(9, sol.longestConsecutive(nums));
	}

	@Test
	void test2() {
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		LargestConsecutiveSequence sol = new LargestConsecutiveSequence();
		assertEquals(4, sol.longestConsecutive(nums));
	}

	@Test
	void test3() {
		int[] nums = { 9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6 };
		LargestConsecutiveSequence sol = new LargestConsecutiveSequence();
		assertEquals(7, sol.longestConsecutive(nums));
	}

}
