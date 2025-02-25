package hsbcMock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LongestCommonSequenceTest {

	@Test
	void test() {
		LongestCommonSequence sol = new LongestCommonSequence();
		assertEquals(4, sol.longestCommonSequence("AGGTAB", "GXTXAYB"));
	}
}
