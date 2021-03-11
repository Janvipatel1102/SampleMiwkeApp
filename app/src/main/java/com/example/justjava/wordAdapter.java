package com.example.justjava;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class wordAdapter extends ArrayAdapter<word> {

    private static final String TAG = "wordAdapter";
    int bcolor;
    public wordAdapter(Context context, ArrayList<word> words,int backGroundColor) {
        super(context, 0, words);
        bcolor = backGroundColor;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        word currentWord  = getItem(position);
        TextView englishTranslation = (TextView) listItemView.findViewById(R.id.english);
        TextView miwokeTranslation = (TextView) listItemView.findViewById(R.id.miwoke);
        ImageView image = (ImageView) listItemView.findViewById(R.id.imageView);
        englishTranslation.setText(currentWord.getDefaultWord());
        miwokeTranslation.setText(currentWord.getMiwokWord());
        image.setImageResource(currentWord.getUri());
        View textContainer = listItemView.findViewById(R.id.container);
        int color  = ContextCompat.getColor(getContext(),bcolor);
        textContainer.setBackgroundColor(color);


        Log.v(TAG,String.valueOf(currentWord.getUri()));

        return listItemView;
    }
}
