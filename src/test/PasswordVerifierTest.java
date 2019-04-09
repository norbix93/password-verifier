package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import main.PasswordVerifier;


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

        Assertions.assertEquals(actual, expected);
        Assertions.assertNotNull(actual);
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

        Assertions.assertEquals(actual, expected);
        Assertions.assertNotNull(actual);
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

        Assertions.assertEquals(actual, expected);
        Assertions.assertNotNull(actual);
    }

    @ParameterizedTest
    @CsvSource(value = {

            "abcABC, true",
            "AAABBBCCC, true",
            "AAA123BBB123CCC, true",
            "AAA, true",
            "aaa, true"
    })
    void isNotNull(String password, boolean expected) {
        boolean actual = passwordVerifier.isNotNull(password);

        Assertions.assertEquals(actual, expected);
        Assertions.assertNotNull(password);
    }
}