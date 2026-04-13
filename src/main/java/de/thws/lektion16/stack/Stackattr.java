package de.thws.lektion16.stack;

import java.util.ArrayList;

public class Stackattr implements StackInterface{
    ArrayList list;

    public boolean push(Object object){
        return this.list.add(object);
    }

    public Object pop(){
        return this.list.remove(this.list.size()-1);
    }

}
