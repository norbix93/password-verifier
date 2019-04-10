package test;

import main.PasswordVerifier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PasswordVerifierTest {

    private PasswordVerifier passwordVerifier = new PasswordVerifier();

    @ParameterizedTest
    @CsvSource(value = {

            "abcabc, false",
            "abcABC, false",
            "abcABC12, false",
            "abcABC123ABC, true",
            "123, false"
    })
    void meetsAllRequirements(String password, boolean expected) {
        boolean actual = passwordVerifier.meetsAllRequirements(password);

        assertEquals(expected, actual);
        assertNotNull(actual);
    }

    @ParameterizedTest
    @CsvSource(value = {

            "abcabc, false",
            "abcABC, false",
            "abcABC12, true",
            "abcABC123ABC, true",
    })
    void meetsThreeRequirements(String password, boolean expected) {
        boolean actual = passwordVerifier.meetsThreeRequirements(password);

        assertEquals(expected, actual);
        assertNotNull(actual);
    }

    @ParameterizedTest
    @CsvSource(value = {

            "abcABC, true",
            "AAABBBCCC, false",
            "AAA123BBB123CCC, false",
            "AAA, false",
            "aaa, true"
    })
    void hasOneLowercaseLetter(String password, boolean expected) {
        boolean actual = passwordVerifier.hasOneLowercaseLetter(password);

        assertEquals(expected, actual);
        assertNotNull(actual);
    }

    @Test
    void isNotNull() {
        boolean actual = passwordVerifier.isNotNull(null);

        assertEquals(false, actual);
        assertNotNull(actual);
    }
}