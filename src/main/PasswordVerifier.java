package main;

public class PasswordVerifier {

    private RequirementReader reader = new RequirementReader();

    public boolean meetsAllRequirements(String password) {
        String allPatterns = reader.readPatternForAllRequirements();
        return password.matches(allPatterns) && isNotNull(password);
    }

    public boolean meetsThreeRequirements(String password) {
        String threePatterns = reader.readPatternForThreeRequirements();
        return password.matches(threePatterns) && isNotNull(password);
    }

    public boolean hasOneLowercaseLetter(String password) {
        String oneLowercasePattern = reader.readPatternForOneRequirement();
        return password.matches(oneLowercasePattern) && isNotNull(password);
    }

    public boolean isNotNull(String password) {
        return !password.equals(null);
    }
}
