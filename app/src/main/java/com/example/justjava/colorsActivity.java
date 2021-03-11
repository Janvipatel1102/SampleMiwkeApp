package com.example.justjava;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class colorsActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;


    private AudioManager audioManager;
    AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)
            {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_GAIN)
            {
                mediaPlayer.start();
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_LOSS)
            {
                releaseMediaPlayer();
            }

        }
    };



    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {

            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        int[] imageRes = {
                R.drawable.color_red,
                R.drawable.color_green,
                R.drawable.color_brown,
                R.drawable.color_gray,
                R.drawable.color_black,
                R.drawable.color_white,
                R.drawable.color_dusty_yellow,
                R.drawable.color_mustard_yellow,

        };

        int[] songRes = {
                R.raw.color_red,
                R.raw.color_green,
                R.raw.color_brown,
                R.raw.color_gray,
                R.raw.color_black,
                R.raw.color_white,
                R.raw.color_dusty_yellow,
                R.raw.color_mustard_yellow,


        };

        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        LinearLayout linearLayout =(LinearLayout) findViewById(R.id.textContainer);
       // linearLayout.setBackgroundResource(R.color.lightPurple);


        ArrayList<word> colors = new ArrayList<word>();
        int image = R.drawable.ic_launcher_foreground;
        colors.add(new word("red","әpә",imageRes[0]));
        colors.add(new word("green","әṭa",imageRes[1]));
        colors.add(new word("brown","angsi",imageRes[2]));
        colors.add(new word("grey","tune",imageRes[3]));
        colors.add(new word("black","taachi",imageRes[4]));
        colors.add(new word("white","chalitti",imageRes[5]));
        colors.add(new word("dusty yellow","ṭopiisә",imageRes[6]));
        colors.add(new word("mustard yellow","chiwiiṭә",imageRes[7]));

        wordAdapter itemsAdapter = new wordAdapter(this, colors,R.color.lightPurple);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                int result = audioManager.requestAudioFocus(afChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(colorsActivity.this, songRes[position]);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(completionListener);

                }


            }
        });

    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to
            // play an audio file at the moment.
            mediaPlayer = null;
            audioManager.abandonAudioFocus(afChangeListener);

        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();

    }
}