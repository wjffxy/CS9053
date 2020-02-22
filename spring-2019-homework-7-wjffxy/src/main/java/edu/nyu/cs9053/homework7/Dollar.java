package edu.nyu.cs9053.homework7;

import java.math.BigDecimal;

public class Dollar extends Money {
    
    public Dollar(BigDecimal amount) {
        super(amount);
    }

    @Override public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        Dollar that = (Dollar) obj;
        return (getAmount() == null ? that.getAmount() == null : getAmount().equals(that.getAmount()));
    }

    @Override public int hashCode() {
        int hashForAmount = (getAmount() == null ? 0: getAmount().hashCode());
        return (hashForAmount * HASH_SEVENTEEN);
    }

}