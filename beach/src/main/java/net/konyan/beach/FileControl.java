package net.konyan.beach;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by zeta on 5/21/16.
 */
public class FileControl {
    final String LOG_TAG = Beach.class.getSimpleName();
    Context context;

    FileControl(Context context){
        this.context = context;
    }

    public boolean writeData(final Object obj) {
        boolean success = false;
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput(obj.getClass().getSimpleName(), Context.MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            success = true;
        } catch (Exception ex) {
            Log.d(LOG_TAG, ex.getMessage());
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {

                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {

                }
            }
        }
        return success;
    }

    public Object readData(String fileName) {
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = context.openFileInput(fileName);
            ois = new ObjectInputStream(fis);
            return ois.readObject();
        } catch (Exception ex) {
            Log.d(LOG_TAG, ex.getMessage());
        }
        return null;
    }

}
