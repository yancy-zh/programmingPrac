package hsbcMock;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

class RemoveDuplicatesTest {

	@Test
	void test() {
		RemoveDuplicates sol = new RemoveDuplicates();
		int[] inArr = new int[] { 1, 1, 3, 2, 1, 4, 5, 4 };
		int[] res = sol.removeDuplicates(inArr);
		assertArrayEquals(res, new int[] { 1, 3, 2, 4, 5 });
	}

}