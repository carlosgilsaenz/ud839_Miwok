package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

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
        words.add(new Word ("minto wuksus","Where are you going?",
                R.raw.phrase_where_are_you_going));
        words.add(new Word ("tinnә oyaase'nә", "What is your name?",
                R.raw.phrase_what_is_your_name));
        words.add(new Word ("oyaaset...","My name is...", R.raw.phrase_my_name_is));
        words.add(new Word ("michәksәs?...","How are you feeling?",
                R.raw.phrase_how_are_you_feeling));
        words.add(new Word ("kuchi achit","I’m feeling good.", R.raw.phrase_im_feeling_good));
        words.add(new Word ("әәnәs'aa?","Are you coming?", R.raw.phrase_are_you_coming));
        words.add(new Word ("hәә’ әәnәm","Yes, I’m coming.", R.raw.phrase_yes_im_coming));
        words.add(new Word ("әәnәm","I’m coming.", R.raw.phrase_im_coming));
        words.add(new Word ("yoowutis","Let’s go.", R.raw.phrase_lets_go));
        words.add(new Word ("yoowutis","Come here.", R.raw.phrase_come_here));

        //create Array adapter to populate ListView
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

        //link listView from XML to local variable
        ListView listView = (ListView) findViewById(R.id.listView);

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
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, sound);
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
