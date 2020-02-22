package edu.nyu.cs9053.homework4.hierarchy;

public abstract class Tree {

    public enum Type {

        Evergreen,
        Deciduous

    };

    private static final int HASH_THIRTYONE = 31;

    private static final int HASH_TWENTYTHREE = 23;

    private static final int HASH_NINETEEN = 19;

    private final String name;

    private final Integer age;

    private final Type type;

    public Tree(String name, int age, Type type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public abstract boolean isSeedEnclosed();
    
    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
