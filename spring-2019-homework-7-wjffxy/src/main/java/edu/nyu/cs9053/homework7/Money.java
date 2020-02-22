package edu.nyu.cs9053.homework7;

import java.math.BigDecimal;

public class Money {

    public static final int HASH_SEVENTEEN = 17;

    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        Money that = (Money) obj;
        return (getAmount() == null ? that.getAmount() == null : getAmount().equals(that.getAmount()));
    }

    @Override public int hashCode() {
        int hashForAmount = (getAmount() == null ? 0: getAmount().hashCode());
        return (hashForAmount * HASH_SEVENTEEN);
    }

}