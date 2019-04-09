package main;

import java.util.List;
import java.util.stream.Collectors;

public class RequirementReader {

    private FileReader reader = new FileReader();

    public List<Requirement> readRequirements() {
        return reader.asStream("main/resources/requirements.csv")
                .skip(1)
                .map(line -> line.split(";"))
                .map(columns -> new Requirement(columns[0], columns[1]))
                .collect(Collectors.toList());
    }

    public String readPatternForAllRequirements() {
        String finalPattern = readRequirements().stream()
                .map(e -> e.getPattern())
                .collect(Collectors.joining());
        return compile(finalPattern);
    }

    public String readPatternForThreeRequirements() {
        String threePatterns = readRequirements().stream()
                .limit(3)
                .map(e -> e.getPattern())
                .collect(Collectors.joining());
        return compile(threePatterns);
    }

    public String readPatternForOneRequirement() {
        String pattern = readRequirements().get(1).getPattern();
        return compile(pattern);
    }

    public String compile(String finalPattern) {
        return "^" + finalPattern + ".*$";
    }
}
