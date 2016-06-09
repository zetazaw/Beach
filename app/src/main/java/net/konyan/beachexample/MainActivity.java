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

       /* MyObject myObject = new MyObject(2, "My Object_"+(2));

        boolean b = Beach.insert("key", myObject).save();

        System.out.println("Success : "+b);

        MyObject readObj = Beach.where("key").get();

        System.out.println(readObj.getName());*/

        Beach.where("key").clear();

        /*ArrayList<MyObject> obj = new ArrayList<>();

        for (int i = 0 ; i<5; i++){
            MyObject myObject = new MyObject(i+1, "My Object_"+(i+1));
            obj.add(myObject);
        }

        Beach.insert("key", obj).commit();*/

        MyObject myObject = new MyObject(2, "My Object_"+(2));

        boolean b = Beach.insert("key", myObject).save();

        System.out.println("Success : "+b);

        List<MyObject> objects = Beach.where("key").query();

        System.out.println("Result size:"+objects.size());

        MyObject result = Beach.where("key").search("name","My Object_2");

        System.out.println(result.getId()+" - "+result.getName());


    }
}
