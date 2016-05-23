package net.konyan.beach;

import android.content.Context;

import java.util.List;

/**
 * Created by zeta on 5/22/16.
 */
public class Controller {

    Context context;

    Controller(Context context){
        this.context = context;
    }

    /*public void write(Object object){
        FileControl fileControl = new FileControl(context);
        Object result = fileControl.readData(object.getClass().getName());
        List<Object> objList = (List<Object>) result;
        if (objList != null){
            objList.add(object);
            fileControl.writeData(objList);
        }
    }

    public <T> List<T> read(Class clazz){
        FileControl fileControl = new FileControl(context);
        return (List<T>) fileControl.readData(clazz.getName());
    }*/

}
