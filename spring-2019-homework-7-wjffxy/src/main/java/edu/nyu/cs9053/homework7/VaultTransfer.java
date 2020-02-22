package edu.nyu.cs9053.homework7;

public class VaultTransfer {
    
    public <T> void transfer(Vault<? extends T> vaultFrom, Vault<? super T> vaultTo) {
        if ((vaultFrom == null) || (vaultTo == null)) {
            return;
        }
        
        for (int i = 0; i < vaultFrom.size(); i++) {
            T itemInFrom = vaultFrom.get(i);
            vaultTo.add(itemInFrom);
        }
    }
}   