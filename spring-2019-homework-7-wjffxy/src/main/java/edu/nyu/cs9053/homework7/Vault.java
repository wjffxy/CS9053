package edu.nyu.cs9053.homework7;

import java.util.concurrent.atomic.AtomicReference;

public class Vault<T> {

    private final AtomicReference<T[]> array;

    private final ArrayCreator<T> arrayCreator;

    public Vault(ArrayCreator<T> arrayCreator) {
        this.arrayCreator = arrayCreator;
        this.array = new AtomicReference();
        this.array.set(arrayCreator.create(0));
    }

    public boolean add(T value) {
        if(value == null) {
            return false;
        }
        if(contains(value)) {
            return false;
        } else {
            int size = size();
            AtomicReference<T[]> arrayBeforeAdd = array;
            resize(size + 1);
            System.arraycopy(arrayBeforeAdd.get(),0,array.get(),size - 1, size);
            array.get()[size] = value;
            return true;
        }
    }

    private void resize(int size) {
        array.set(arrayCreator.create(size));
    }

    public boolean contains(T value) {
        for(int i = 0; i < size(); i++) {
            if(array.get()[i] == value) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(T value) {
        for(int i = 0; i < size(); i++) {

            if(array.get()[i] == value) {
                int size = size();
                AtomicReference<T[]> arrayBeforeRemove = array;
                resize(size - 1);
                for(int j = 0; j < size(); j++) {
                    if(j < i) {
                        array.get()[j] = arrayBeforeRemove.get()[j];
                    } else {
                        array.get()[j] = arrayBeforeRemove.get()[j + 1];
                    }
                }
                return true;
            }
        }
        return false;
    }

    public T get(int index) {
        if(index >= size() || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array.get()[index];
    }

    public int size() {
        return array.get().length;
    }
}