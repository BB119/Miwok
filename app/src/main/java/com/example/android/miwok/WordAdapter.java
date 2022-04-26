package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    /** The list background color */
    private int mBackgroundColor;
    /** The media player */
    private MediaPlayer mMediaPlayer;
    /**
     * Default WordAdapter constructor
     * @param context the context of the calling class
     * @param words the data that's gonna be populated in the list view
     */
    public WordAdapter(Activity context, ArrayList<Word> words, int backgroundColor) {
        super(context, 0, words);
        mBackgroundColor = backgroundColor;
        mMediaPlayer = new MediaPlayer();
    }

    /**
     * Gets the view for each row in the list view
     * @param position the index of the data in the data array
     * @param convertView the view for a single row
     * @param parent the parent of the row view
     * @return the populated row view
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Getting the wanted Word
        Word currentWord = getItem(position);

        // Checking if the convert view is being recycled, otherwise inflate a new one
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);
        }

        // Getting the text views in the row view
        TextView miwokTextView = (TextView)listItemView.findViewById(R.id.miwok_text_view);
        TextView defaultTranslationTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

        // Setting their texts from the data word
        miwokTextView.setText(currentWord.getmMiwokTranslation());
        defaultTranslationTextView.setText(currentWord.getmDefaultTranslationWord());

        // Setting the background of the linear layout of the text views
        LinearLayout linearLayout = (LinearLayout)listItemView.findViewById(R.id.text_views_layout);
        linearLayout.setBackgroundColor(ContextCompat.getColor(getContext(), mBackgroundColor));

        //Setting the image view if it's not null
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(currentWord.getmImageResourceId());
        } else {
            imageView.setVisibility(View.GONE);
        }

        // Return the populated row view
        return listItemView;
    }

    public MediaPlayer getmMediaPlayer() {
        return mMediaPlayer;
    }
}
