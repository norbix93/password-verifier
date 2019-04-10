package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import main.Requirement;
import main.RequirementReader;

import java.util.List;

class RequirementReaderTest {

    private RequirementReader reader = new RequirementReader();

    @Test
    void readRequirements() {
        List<Requirement> actual = reader.readRequirements();

        Assertions.assertNotNull(actual);
        Assertions.assertEquals(4, actual.size());
        Assertions.assertNotEquals(9, actual.size());
    }

    @Test
    void readPatternForAllRequirements() {
        String actual = reader.readPatternForAllRequirements();
        String expected = "^(?=(.*[A-Z]))(?=(.*[a-z]))(?=(.*[\\d])).{9,}$.*$";

        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void readPatternForThreeRequirements() {
        String actual = reader.readPatternForThreeRequirements();
        String expected = "^(?=(.*[A-Z]))(?=(.*[a-z]))(?=(.*[\\d])).*$";

        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void readPatternForOneRequirement() {
        String actual = reader.readPatternForOneRequirement();
        String expected = "^(?=(.*[a-z])).*$";

        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
    }
}