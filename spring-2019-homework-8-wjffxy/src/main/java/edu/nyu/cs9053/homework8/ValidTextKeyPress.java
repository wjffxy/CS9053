package edu.nyu.cs9053.homework8;

public enum ValidTextKeyPress {

    Two("abc"),
    Three("def"),
    Four("ghi"),
    Five("jkl"),
    Six("mno"),
    Seven("pqrs"),
    Eight("tuv"),
    Nine("wxyz");

    private final String description;

    private ValidTextKeyPress(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}