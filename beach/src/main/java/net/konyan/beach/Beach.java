package net.konyan.beach;

import android.content.Context;

import java.io.Serializable;
import java.lang.reflect.Field;
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

    public static Beach where(String key){
        try {
            beach.key = key;
        }catch (NullPointerException npe){
            throw new RuntimeException(Beach.class.getSimpleName() + " need to init first!");
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
                beach.object = value;
            }else {
                throw new RuntimeException(Beach.class.getSimpleName() + " cannot deal with null data!");
            }

        }catch (NullPointerException npe){
            throw new RuntimeException(Beach.class.getSimpleName() + " need to init first!");
        }
        return beach;
    }

    /*
    db operation style
     */
    public boolean commit(){
        FileControl fileControl = new FileControl(context);
        List<Object> l = (List<Object>) fileControl.readData(key);

        if (list != null){
            if (l != null){
                list.addAll(l);
            }
            return fileControl.writeData(key, list);
        }
        throw new RuntimeException(Beach.class.getSimpleName() + " cannot commit with null data!");
    }

    /*
    single object save as a file
     */
    public boolean save(){
        FileControl fileControl = new FileControl(context);
        if (object instanceof Object){
            return fileControl.writeData(key, object);
        }
        return false;

    }

    public <T>T query(){
        FileControl fileControl = new FileControl(context);
        return (T) fileControl.readData(key);
    }

    public boolean clear(){
        FileControl fileControl = new FileControl(context);
        return fileControl.deleteFile(key);
    }

    /*
    it's work but too weak to use; need to test a lot
     */
    public <T> T search(String name, Object value){
        List<?> l = query();
        for (Object o : l){
            try {
                Field f = o.getClass().getField(name);
                Object temp = f.get(o);
                if (temp.equals(value)){
                    return (T)o;
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
