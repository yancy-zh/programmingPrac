import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CheckAlmostEquivalenceTest {

	@Test
	void test1() {
		assertEquals(CheckAlmostEquivalence.checkAlmostEquivalent("aaaa", "bccb"), false);
	}

	@Test
	void test2() {
		assertEquals(CheckAlmostEquivalence.checkAlmostEquivalent("abcdeef", "abaaacc"), true);
	}

	@Test
	void test3() {
		assertEquals(CheckAlmostEquivalence.checkAlmostEquivalent("cccddabba", "babababab"), true);
	}
}
