package edu.nyu.cs9053.homework7;

public class BankVault<T extends Money> extends Vault<T> {

    public BankVault(ArrayCreator<T> arrayCreator) {
        super(arrayCreator);
    }
}