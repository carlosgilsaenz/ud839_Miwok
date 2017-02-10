package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        //create ArrayList for words
        ArrayList<Word> words = new ArrayList<>();

        //add values to ArrayList
        words.add(new Word ("Lutti","red"));
        words.add(new Word ("Otiiko", "green"));
        words.add(new Word ("Tolookosu","brown"));
        words.add(new Word ("Oyyisa","gray"));
        words.add(new Word ("Massokka","black"));
        words.add(new Word ("Temmokka","white"));
        words.add(new Word ("Kenekaku", "dusty yellow"));
        words.add(new Word ("Kawinta","mustard yellow"));

        //create Array adapter to populate ListView
        WordAdapter adapter = new WordAdapter(this, words);

        //link listView from XML to local variable
        ListView listView = (ListView) findViewById(R.id.listView);

        //set array adapter to listView
        listView.setAdapter(adapter);
    }
}
