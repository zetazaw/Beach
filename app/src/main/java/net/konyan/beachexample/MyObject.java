package net.konyan.beachexample;

import java.io.Serializable;

/**
 * Created by zeta on 5/21/16.
 */
public class MyObject implements Serializable{
    int id;
    String name;

    public MyObject() {
    }

    public MyObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
