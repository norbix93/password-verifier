package main;

public class Requirement {

    private String description;
    private String pattern;

    public Requirement(String description, String pattern) {
        this.description = description;
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    @Override
    public String toString() {
        return pattern;
    }
}
