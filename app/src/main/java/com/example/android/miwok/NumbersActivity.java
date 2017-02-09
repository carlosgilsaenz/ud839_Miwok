package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        //create ArrayList for words
        ArrayList<Word> words = new ArrayList<>();

        //add values to ArrayList
        words.add(new Word ("Lutti","One"));
        words.add(new Word ("Otiiko", "Two"));
        words.add(new Word ("Tolookosu","Three"));
        words.add(new Word ("Oyyisa","Four"));
        words.add(new Word ("Massokka","Five"));
        words.add(new Word ("Temmokka","Six"));
        words.add(new Word ("Kenekaku","Seven"));
        words.add(new Word ("Kawinta","Eight"));
        words.add(new Word ("Wo'e","Nine"));
        words.add(new Word ("Na'aacha","Ten"));

        //create Array adapter to populate ListView
        WordAdapter adapter = new WordAdapter(this, words);

        //link listView from XML to local variable
        ListView listView = (ListView) findViewById(R.id.listView);

        //set array adapter to listView
        listView.setAdapter(adapter);
    }
}
