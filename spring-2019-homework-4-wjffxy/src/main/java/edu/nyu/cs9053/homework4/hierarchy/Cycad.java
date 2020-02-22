package edu.nyu.cs9053.homework4.hierarchy;

public class Cycad extends Tree {

    private static final boolean DEFAULT_ISSEEDENCLOSED = false;

    private static final Type DEFAULT_TYPE = Type.Evergreen;

    private static final boolean DEFAULT_ISEUDICOT = false;

    private static final int HASH_SEVENTEEN = 17;

    private final String color;

    public Cycad(String name, int age, String color) {
        super(name, age, DEFAULT_TYPE);
        this.color = color;
    }

    @Override public boolean isSeedEnclosed() {
        return DEFAULT_ISSEEDENCLOSED;
    }
    
    public boolean isEudicot() {
        return DEFAULT_ISEUDICOT;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        Cycad that = (Cycad) obj;
        return (color == null ? that.color == null : color.equals(that.color))
            && (name == null ? that.name == null : name.equals(that.name))
            && (type == null ? that.type == null : type.equals(that.type))
            && (age == null ? that.age == null : age.equals(that.age));
    }

    @Override public int hashCode() {
        int hashForColor = (color == null ? 0 : color.hashCode());
        int hashForName = (name == null ? 0 : name.hashCode());
        int hashForType = (type == null ? 0 : type.hashCode());
        int hashForAge = (age == null ? 0: age.hashCode());
        int result = (hashForName * HASH_THIRTYONE) + (hashForType * HASH_TWENTYTHREE) + (hashForAge * HASH_NINETEEN);
        return (result + (hashForColor * HASH_SEVENTEEN));
    }
}