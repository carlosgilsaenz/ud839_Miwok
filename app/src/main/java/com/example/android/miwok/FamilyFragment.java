package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/**
 * Created by csaenz on 2/15/2017.
 */

public class FamilyFragment extends Fragment{

    MediaPlayer mMediaPlayer;

    AudioManager mAudioManager;

    //set completion listener to clean up Media Files
    MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    //setting onAudioChangeListener
    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AUDIOFOCUS_GAIN || focusChange == AUDIOFOCUS_GAIN_TRANSIENT || focusChange == AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK){
                if (mMediaPlayer != null){mMediaPlayer.start();}
            }
            else if(focusChange == AUDIOFOCUS_LOSS || focusChange == AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                releaseMediaPlayer();
            }

        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.words_list, container,false);

        //Initialize AudioManager to get system Service
        mAudioManager = (AudioManager)getActivity().getSystemService(Context.AUDIO_SERVICE);

        //create ArrayList for words
        final ArrayList<Word> words = new ArrayList<>();

        //add values to ArrayList
        words.add(new Word ("әpә", "father", R.drawable.family_father,
                R.raw.family_father));
        words.add(new Word ("әṭa", "mother", R.drawable.family_mother,
                R.raw.family_mother));
        words.add(new Word ("angsi", "son", R.drawable.family_son,
                R.raw.family_son));
        words.add(new Word ("tune", "daughter", R.drawable.family_daughter,
                R.raw.family_daughter));
        words.add(new Word ("taachi", "older brother", R.drawable.family_older_brother,
                R.raw.family_older_brother));
        words.add(new Word ("chalitti", "younger brother", R.drawable.family_younger_brother,
                R.raw.family_younger_brother));
        words.add(new Word ("teṭe", "older sister", R.drawable.family_older_sister,
                R.raw.family_older_sister));
        words.add(new Word ("kolliti", "younger sister", R.drawable.family_younger_sister,
                R.raw.family_younger_sister));
        words.add(new Word ("ama","grandmother", R.drawable.family_grandmother,
                R.raw.family_grandmother));
        words.add(new Word ("paapa","grandfather", R.drawable.family_grandfather,
                R.raw.family_grandfather));

        //create Array adapter to populate ListView
        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_family);

        //link listView from XML to local variable
        ListView listView = (ListView) rootView.findViewById(R.id.listView);

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
                    mMediaPlayer = MediaPlayer.create(getActivity(), sound);
                    mMediaPlayer.start();

                    //setup Listener to clean up Media files
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                } else{
                    Toast.makeText(getActivity(),"Background Application preventing Sound Playback",
                            Toast.LENGTH_SHORT).show();}
            }
        });

        return rootView;
    }

    /**
     * customer onStop to improve resource usage
     */
    @Override
    public void onStop() {
        super.onStop();
        //ensure media player is released
        releaseMediaPlayer();
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
