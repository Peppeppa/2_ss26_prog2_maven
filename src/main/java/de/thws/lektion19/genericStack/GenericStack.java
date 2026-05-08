package de.thws.lektion19.genericStack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GenericStack<E> implements StackInterface<E> {

    private ArrayList<E> list = new ArrayList<>();

    @Override
    public boolean push(E element){
        return list.add(element);
    }

    @Override
    public E pop(){
        if(list.isEmpty()){
            throw new RuntimeException("Stack ist leer");
        }
        return list.remove(list.size() -1);
    }


}

