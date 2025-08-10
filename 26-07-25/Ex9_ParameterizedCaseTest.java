package com.wipro.junittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.wipro.junit.CheckCaseParameterized;

class ParameterizedCaseTest {
	CheckCaseParameterized checkcase = new CheckCaseParameterized();
	
	@ParameterizedTest
    @ValueSource(strings = {"hello", "test", "lowercase", "junit"})
    void testIsLowerCaseTrue(String str) {
        assertTrue(checkcase.isLowerCase(str));
    }

//    @ParameterizedTest
//    @ValueSource(strings = {"Hello", "Test", "JUNIT", "123", "", " "})
//    void testIsLowerCaseFalse(String str) {
//        assertFalse(checkcase.isLowerCase(str));
//    }

}
