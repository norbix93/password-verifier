package main;

import java.util.Objects;

public class PasswordVerifier {

    private RequirementReader reader = new RequirementReader();

    public boolean meetsAllRequirements(String password) {
        String allPatterns = reader.readPatternForAllRequirements();
        return isNotNull(password) && password.matches(allPatterns);
    }

    public boolean meetsThreeRequirements(String password) {
        String threePatterns = reader.readPatternForThreeRequirements();
        return isNotNull(password) && password.matches(threePatterns);
    }

    public boolean hasOneLowercaseLetter(String password) {
        String oneLowercasePattern = reader.readPatternForOneRequirement();
        return isNotNull(password) && password.matches(oneLowercasePattern);
    }

    public boolean isNotNull(String password) {
        return Objects.nonNull(password);
    }
}
