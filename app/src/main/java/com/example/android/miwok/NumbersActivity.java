package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        //create ArrayList for words
        ArrayList<Word> words = new ArrayList<>();

        //add values to ArrayList
        words.add(new Word ("Lutti","One", R.drawable.number_one));
        words.add(new Word ("Otiiko", "Two", R.drawable.number_two));
        words.add(new Word ("Tolookosu","Three", R.drawable.number_three));
        words.add(new Word ("Oyyisa","Four", R.drawable.number_four));
        words.add(new Word ("Massokka","Five", R.drawable.number_five));
        words.add(new Word ("Temmokka","Six", R.drawable.number_six));
        words.add(new Word ("Kenekaku","Seven", R.drawable.number_seven));
        words.add(new Word ("Kawinta","Eight", R.drawable.number_eight));
        words.add(new Word ("Wo'e","Nine", R.drawable.number_nine));
        words.add(new Word ("Na'aacha","Ten", R.drawable.number_ten));

        //create Array adapter to populate ListView
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

        //link listView from XML to local variable
        ListView listView = (ListView) findViewById(R.id.listView);

        //set array adapter to listView
        listView.setAdapter(adapter);
    }
}
