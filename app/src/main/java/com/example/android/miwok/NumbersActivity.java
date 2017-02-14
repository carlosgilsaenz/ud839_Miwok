package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    MediaPlayer mMediaPlayer;

    //set completion listener to clean up Media Files
    MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        //create ArrayList for words
        final ArrayList<Word> words = new ArrayList<>();

        //add values to ArrayList
        words.add(new Word ("Lutti","One", R.drawable.number_one, R.raw.number_one));
        words.add(new Word ("Otiiko", "Two", R.drawable.number_two, R.raw.number_two));
        words.add(new Word ("Tolookosu","Three", R.drawable.number_three, R.raw.number_three));
        words.add(new Word ("Oyyisa","Four", R.drawable.number_four, R.raw.number_four));
        words.add(new Word ("Massokka","Five", R.drawable.number_five, R.raw.number_five));
        words.add(new Word ("Temmokka","Six", R.drawable.number_six, R.raw.number_six));
        words.add(new Word ("Kenekaku","Seven", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word ("Kawinta","Eight", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word ("Wo'e","Nine", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word ("Na'aacha","Ten", R.drawable.number_ten, R.raw.number_ten));

        //create Array adapter to populate ListView
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

        //link listView from XML to local variable
        final ListView listView = (ListView) findViewById(R.id.listView);
        //set array adapter to listView
        listView.setAdapter(adapter);

        //Onclick listener for sound files for each list view item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //extract sound ref from word Array list
                int sound = words.get(position).getSound();

                //ensure Media file is empty
                releaseMediaPlayer();

                //set and play sound
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, sound);
                mMediaPlayer.start();

                //setup Listener to clean up Media files
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    /**
     * customer onStop to improve resource usage
     */

    @Override
    protected void onStop() {
        super.onStop();

        //ensure media player is released
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}


