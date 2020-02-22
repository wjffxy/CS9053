package edu.nyu.cs9053.homework7;

public class DollarArrayCreator implements ArrayCreator<Dollar> {

    public Dollar[] create(int size) {
        return new Dollar[size];
    }
}