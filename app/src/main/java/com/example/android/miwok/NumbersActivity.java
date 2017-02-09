package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        //create ArrayList for words
        ArrayList<String> words = new ArrayList<String>();

        //add values to ArrayList
        words.add("One");
        words.add("Two");

        //set Linear Layout to variable
        LinearLayout wordLayout = (LinearLayout) findViewById(R.id.activity_numbers);

        TextView number0 = new TextView(this);
        number0.setText(words.get(0));
        wordLayout.addView(number0);

        TextView number1 = new TextView(this);
        number1.setText(words.get(1));
        wordLayout.addView(number1);
    }
}
