package algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PartitionEqualSubsetSumTest {

	@Test
	void test1() {
		PartitionEqualSubsetSum sol = new PartitionEqualSubsetSum();
		assertEquals(sol.canPartition(new int[] { 1, 5, 11, 5 }), true);
	}

	@Test
	void test2() {
		PartitionEqualSubsetSum sol = new PartitionEqualSubsetSum();
		assertEquals(sol.canPartition(new int[] { 1, 2, 3, 5 }), false);
	}

}
