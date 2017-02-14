package com.example.android.miwok;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.media.AudioManager.AUDIOFOCUS_GAIN;
import static android.media.AudioManager.AUDIOFOCUS_GAIN_TRANSIENT;
import static android.media.AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK;
import static android.media.AudioManager.AUDIOFOCUS_LOSS;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK;
import static android.media.AudioManager.STREAM_MUSIC;

public class ColorsActivity extends AppCompatActivity {

    MediaPlayer mMediaPlayer;

    AudioManager mAudioManager;

    //set completion listener to clean up Media Files
    MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    };

    //setting onAudioChangeListener
    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AUDIOFOCUS_GAIN || focusChange == AUDIOFOCUS_GAIN_TRANSIENT || focusChange == AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK){
                mMediaPlayer.start();
                mMediaPlayer.seekTo(0);
                }
            else if(focusChange == AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mMediaPlayer.pause();
                }
            else if(focusChange == AUDIOFOCUS_LOSS){
                    releaseMediaPlayer();
                }
            }
        };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        //Initialize AudioManager to get system Service
        mAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        //create ArrayList for words
        final ArrayList<Word> words = new ArrayList<>();

        //add values to ArrayList
        words.add(new Word ("Weṭeṭṭi","red", R.drawable.color_red, R.raw.color_red));
        words.add(new Word ("Chokokki", "green", R.drawable.color_green, R.raw.color_green));
        words.add(new Word ("Takaakki","brown", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word ("Topoppi","gray", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word ("Kululli","black", R.drawable.color_black, R.raw.color_black));
        words.add(new Word ("Kelelli","white", R.drawable.color_white, R.raw.color_white));
        words.add(new Word ("Topiisә", "dusty yellow", R.drawable.color_dusty_yellow,
                R.raw.color_dusty_yellow));
        words.add(new Word ("Chiwiiṭә","mustard yellow", R.drawable.color_mustard_yellow,
                R.raw.color_mustard_yellow));

        //create Array adapter to populate ListView
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

        //link listView from XML to local variable
        ListView listView = (ListView) findViewById(R.id.listView);

        //set array adapter to listView
        listView.setAdapter(adapter);

        //Onclick listener for sound files for each list view item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //request audio focus and store results in INT RESULTS
                int results = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,STREAM_MUSIC,AUDIOFOCUS_GAIN_TRANSIENT);

                //if GAIN focus then play audio
                if(results == AUDIOFOCUS_GAIN){

                    //extract sound ref from word Array list
                    int sound = words.get(position).getSound();

                    //ensure Media file is empty
                    releaseMediaPlayer();

                    //set and play sound
                    mMediaPlayer = MediaPlayer.create(ColorsActivity.this, sound);
                    mMediaPlayer.start();

                    //setup Listener to clean up Media files
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                } else{
                    Toast.makeText(ColorsActivity.this,"Background Application preventing Sound Playback",
                            Toast.LENGTH_SHORT).show();}
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
        //release OnAudioChangeListener
        mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
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
