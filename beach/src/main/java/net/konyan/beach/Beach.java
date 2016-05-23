package net.konyan.beach;

import android.content.Context;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeta on 5/21/16.
 */
public class Beach {
    static final String LOG_TAG = Beach.class.getSimpleName();
    Context context;
    String key;
    List<Object> list;


    static Beach beach;

    Beach(Context context){
        this.context = context;
    }

    public static void init(Context context){
        if (beach == null){
            beach = new Beach(context);
        }
    }

    public static Beach where(String key){
        try {
            beach.key = key;
        }catch (NullPointerException npe){
            throw new NullPointerException(Beach.class.getSimpleName() + " need to init first!");
        }
        return beach;
    }

    /*
    check instance of list first because list is also object
     */
    public static <T extends Serializable> Beach insert(String key, T value){
        try {
            beach.key = key;
            if (value instanceof List<?>){
                beach.list =(List) value;
            }
            else if (value instanceof Object){
                beach.list = new ArrayList<>();
                beach.list.add(value);
            }

        }catch (NullPointerException npe){
            throw new NullPointerException(Beach.class.getSimpleName() + " need to init first!");
        }
        return beach;
    }

    public boolean commit(){
        FileControl fileControl = new FileControl(context);
        List<Object> l = (List<Object>) fileControl.readData(key);

        if (list != null){
            if (l != null){
                list.addAll(l);
            }


            return fileControl.writeData(key, list);
        }throw new NullPointerException("Cannot commit the null data!");

    }

    public <T>List<T> query(){
        FileControl fileControl = new FileControl(context);
        return (List<T>) fileControl.readData(key);
    }

    public boolean clear(){
        FileControl fileControl = new FileControl(context);
        return fileControl.deleteFile(key);
    }
}
