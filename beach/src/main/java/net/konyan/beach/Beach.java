package net.konyan.beach;

import android.content.Context;
import android.util.Log;

/**
 * Created by zeta on 5/21/16.
 */
public class Beach {
    static final String LOG_TAG = Beach.class.getSimpleName();
    Context context;
    Class clazz;
    Object object;

    static Beach beach;

    Beach(Context context){
        this.context = context;
    }

    public static void init(Context context){
        if (beach == null){
            beach = new Beach(context);
        }
    }

    public static Beach where(Class clazz){
        try {
            beach.clazz = clazz;
        }catch (NullPointerException npe){
            throw new NullPointerException(Beach.class.getSimpleName() + " need to init first!");
        }
        return beach;
    }

    public static Beach insert(Object object){
        try {
            beach.clazz = object.getClass();
            beach.object = object;
            Log.d(LOG_TAG, "Successfully insert");
            return beach;
        }catch (NullPointerException npe){
            throw new NullPointerException(Beach.class.getSimpleName() + " need to init first!");
        }

    }

    public boolean commit(){
        FileControl fileControl = new FileControl(context);
        return fileControl.writeData(object);
    }

    public <T>T query(){
        FileControl fileControl = new FileControl(context);
        Object obj = fileControl.readData(clazz.getSimpleName());
        return (T) obj;
    }
}
