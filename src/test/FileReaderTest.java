package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import main.FileReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class FileReaderTest {

    private FileReader reader = new FileReader();

    @Test
    void asStream() {
        List<String> expected = Arrays.asList("Description;Regular expression");
        List<String> actual = reader.asStream("test/resources/document.csv")
                .limit(1)
                .collect(Collectors.toList());

        Assertions.assertEquals(expected, actual);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(actual.size(), 1);
    }
}