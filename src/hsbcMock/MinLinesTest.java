package hsbcMock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MinLinesTest {

	@Test
	void test() {
		int[][] coords = new int[][] { { 1, 1 }, { -1, 1 }, { 2, 3 } };
		MinLines sol = new MinLines();
		assertEquals(3, sol.minLines(coords, 0, 0));

	}

}
