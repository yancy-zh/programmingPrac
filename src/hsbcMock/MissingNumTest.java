package hsbcMock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MissingNumTest {

	@Test
	void test1() {
		MissingNum sol = new MissingNum();
		assertEquals(2, sol.missingNumber(new int[] { 3, 0, 1 }));
	}

	@Test
	void test2() {
		MissingNum sol = new MissingNum();
		assertEquals(2, sol.missingNumber(new int[] { 0, 1 }));
	}

	@Test
	void test3() {
		MissingNum sol = new MissingNum();
		assertEquals(8, sol.missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));
	}
}
