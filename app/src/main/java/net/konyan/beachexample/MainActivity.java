package net.konyan.beachexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import net.konyan.beach.Beach;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Beach.init(this);

        List<MyObject> objects = new ArrayList<>();

        objects.add(new MyObject(1, "A"));
        objects.add(new MyObject(2, "B"));
        objects.add(new MyObject(3, "C"));

        boolean saved = Beach.insert(MyObject.class.getSimpleName(), objects).commit();

        Log.d(LOG_TAG, "saved: " + saved);

        if (saved){
            List<MyObject> savedObjects = Beach.where(MyObject.class.getSimpleName()).query();
            Log.d(LOG_TAG, "last obj size:" + savedObjects.size());
            Log.d(LOG_TAG, "last obj:" + savedObjects.get(savedObjects.size()-1).getName());
        }

        //update new item
        boolean updated = Beach.insert(MyObject.class.getSimpleName(), new MyObject(4, "D")).commit();

        if (updated){
            List<MyObject> savedObjects = Beach.where(MyObject.class.getSimpleName()).query();
            Log.d(LOG_TAG, "last obj size:" + savedObjects.size());
            //last in, fast out
            Log.d(LOG_TAG, "last obj:" + savedObjects.get(0).getName());
        }

    }
}
