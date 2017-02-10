package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        //create ArrayList for words
        ArrayList<Word> words = new ArrayList<>();

        //add values to ArrayList
        words.add(new Word ("әpә", "father"));
        words.add(new Word ("әṭa", "mother"));
        words.add(new Word ("angsi", "son"));
        words.add(new Word ("tune", "daughter"));
        words.add(new Word ("taachi", "older brother"));
        words.add(new Word ("chalitti", "younger brother"));
        words.add(new Word ("teṭe", "older sister"));
        words.add(new Word ("kolliti", "younger sister"));
        words.add(new Word ("ama","grandmother"));
        words.add(new Word ("paapa","grandfather"));

        //create Array adapter to populate ListView
        WordAdapter adapter = new WordAdapter(this, words);

        //link listView from XML to local variable
        ListView listView = (ListView) findViewById(R.id.listView);

        //set array adapter to listView
        listView.setAdapter(adapter);
    }
}
