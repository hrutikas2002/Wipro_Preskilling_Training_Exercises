package com.wipro.junittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.wipro.junit.CheckCase;

class CheckCaseTestTest {

	CheckCase checkcase;

	@BeforeEach
	void setUp() throws Exception {
		checkcase = new CheckCase();
	}

	@Test
	void isUpperCaseTrue() {
		assertTrue(checkcase.isUpperCase("RUTIKA"));
	}
	
	@Test
	void isUpperCaseFalse() {
		assertFalse(checkcase.isUpperCase("srushti"));
	}
}
