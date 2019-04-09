package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import main.Requirement;
import main.RequirementReader;

import java.util.List;

class RequirementReaderTest {

    private RequirementReader reader = new RequirementReader();
    private List<Requirement> actual = reader.readRequirements();

    @Test
    void readRequirements() {

        Assertions.assertNotNull(actual);
        Assertions.assertEquals(4, actual.size());
        Assertions.assertNotEquals(9, actual.size());
    }

    @Test
    void readPatternForAllRequirements() {
        String actualPattern = reader.readPatternForAllRequirements();
        String expected = "^(?=(.*[A-Z]))(?=(.*[a-z]))(?=(.*[\\d])).{9,}$.*$";

        Assertions.assertNotNull(actualPattern);
        Assertions.assertEquals(expected, actualPattern);
    }

    @Test
    void readPatternForThreeRequirements() {
        String actualPattern = reader.readPatternForThreeRequirements();
        String expected = "^(?=(.*[A-Z]))(?=(.*[a-z]))(?=(.*[\\d])).*$";

        Assertions.assertNotNull(actualPattern);
        Assertions.assertEquals(expected, actualPattern);
    }

    @Test
    void readPatternForOneRequirement() {
        String actualPattern = reader.readPatternForOneRequirement();
        String expected = "^(?=(.*[a-z])).*$";

        Assertions.assertNotNull(actualPattern);
        Assertions.assertEquals(expected, actualPattern);
    }
}