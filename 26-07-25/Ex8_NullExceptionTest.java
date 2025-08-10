package com.wipro.junittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.wipro.junit.CheckNullString;

class NullExceptionTest {

	@Test
	void testNullExceptionTrue() {
		CheckNullString str = new CheckNullString();
		assertThrows(NullPointerException.class, () -> {
	        str.checkNull(null);
	    });
	}
	
//	@Test
//	void testNullExceptionFalse() {
//		CheckNullString str = new CheckNullString();
//		assertThrows(NullPointerException.class, () -> {
//	        str.checkNull("rutika");
//	    });
//	}

}
