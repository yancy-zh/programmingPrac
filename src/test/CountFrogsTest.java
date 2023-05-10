package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import huaweiCodingPrac.CountFrogs;

class CountFrogsTest {

	@Test
	void oneFrogTest() {
		CountFrogs cntCountFrogs = new CountFrogs();
		assertEquals(cntCountFrogs.minNumberOfFrogs("croakcroak"), 1);
	}

	@Test
	void twoFrogsTest() {
		CountFrogs cntCountFrogs = new CountFrogs();
		assertEquals(cntCountFrogs.minNumberOfFrogs("crcoakroak"), 2);
	}

	@Test
	void invalidStrTest() {
		CountFrogs cntCountFrogs = new CountFrogs();
		assertEquals(cntCountFrogs.minNumberOfFrogs("croakcrook"), -1);
	}
}
