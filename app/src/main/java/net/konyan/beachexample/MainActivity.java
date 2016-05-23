package net.konyan.beachexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.konyan.beach.Beach;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Beach.init(this);


        /*ArrayList<MyObject> obj = new ArrayList<>();

        for (int i = 0 ; i<10; i++){
            MyObject myObject = new MyObject(i+1, "My Object_"+(i+1));
            obj.add(myObject);
        }*/
        MyObject myObject = new MyObject(1, "My Object_");
        Beach.insert(MyObject.class.getSimpleName(), myObject).commit();

        List<MyObject> objects = Beach.where(MyObject.class.getSimpleName()).query();

        System.out.println("Result size:"+objects.size());


    }
}
