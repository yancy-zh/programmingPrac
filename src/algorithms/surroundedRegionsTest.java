package algorithms;

import static org.junit.Assert.*;
import java.util.Arrays;

import org.junit.Test;

public class surroundedRegionsTest {
	SurroundedRegions surroundedRegions = new SurroundedRegions();

	@Test
	public void test() {
		char[][] src = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		char[][] des = { { 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X' },
				{ 'X', 'O', 'X', 'X' } };
//		char[][] des = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
//				{ 'X', 'O', 'X', 'X' } };
		assertTrue(Arrays.deepEquals(surroundedRegions.solve(src), des));
	}

}
