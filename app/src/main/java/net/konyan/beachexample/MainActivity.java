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
        Beach beach = Beach.create(MyObject.class);
        beach.insert(myObject);
        beach.commit();

        MyObject myObj = Beach.create(MyObject.class).query();
        System.out.println(myObj.getName());
    }
}
