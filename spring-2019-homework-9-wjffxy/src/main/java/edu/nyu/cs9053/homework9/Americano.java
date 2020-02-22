package edu.nyu.cs9053.homework9;

public class Americano implements CoffeeDrink {

    private static final int HASH_THIRTYONE = 31;

    private static final int HASH_TWENTYTHREE = 23;

    private final Boolean isDecaf;

    private final Boolean containsMilk;

    public Americano(Boolean isDecaf, Boolean containsMilk) {
        this.isDecaf = isDecaf;
        this.containsMilk = containsMilk;
    }

    public boolean isDecaf() {
        return isDecaf;
    }

    public boolean containsMilk() {
        return containsMilk;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        Americano that = (Americano) obj;
        return (isDecaf == null ? that.isDecaf == null : isDecaf.equals(that.isDecaf))
            && (containsMilk == null ? that.containsMilk == null : containsMilk.equals(that.containsMilk));
    }

    @Override public int hashCode() {
        int hashForIsDecaf = (isDecaf == null ? 0 : isDecaf.hashCode());
        int hashForContainsMilk = (containsMilk == null ? 0 : containsMilk.hashCode());
        int result = (hashForIsDecaf * HASH_THIRTYONE) + (hashForContainsMilk * HASH_TWENTYTHREE);
        return result;
    }
}