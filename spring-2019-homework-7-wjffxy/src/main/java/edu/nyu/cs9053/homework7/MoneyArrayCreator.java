package edu.nyu.cs9053.homework7;

public class MoneyArrayCreator implements ArrayCreator<Money> {

    public Money[] create(int size) {
        return new Money[size];
    }
}