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
        words.add(new Word ("Lutti","red", R.drawable.color_red));
        words.add(new Word ("Otiiko", "green", R.drawable.color_green));
        words.add(new Word ("Tolookosu","brown", R.drawable.color_brown));
        words.add(new Word ("Oyyisa","gray", R.drawable.color_gray));
        words.add(new Word ("Massokka","black", R.drawable.color_black));
        words.add(new Word ("Temmokka","white", R.drawable.color_white));
        words.add(new Word ("Kenekaku", "dusty yellow", R.drawable.color_dusty_yellow));
        words.add(new Word ("Kawinta","mustard yellow", R.drawable.color_mustard_yellow));

        //create Array adapter to populate ListView
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

        //link listView from XML to local variable
        ListView listView = (ListView) findViewById(R.id.listView);

        //set array adapter to listView
        listView.setAdapter(adapter);
    }
}
