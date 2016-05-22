package net.konyan.beachexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.konyan.beach.Beach;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyObject myObject = new MyObject(1, "My Object");

        Beach.init(this);

        boolean success = Beach.insert(myObject).commit();

        System.out.println("Commit success :"+success);

        MyObject readObj = Beach.where(MyObject.class).query();

        System.out.println("My obj>"+readObj.getName());

    }
}
