package com.aysin.rahul.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rahul on 29-03-2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Activity context, ArrayList<Word> Word){
        super(context, 0, Word);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null)
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        Word currentword = getItem(position);

        ImageView iconview = (ImageView)listItemView.findViewById(R.id.list_item_icon);
        if(currentword.hasImage()){
            iconview.setImageResource(currentword.getImageResourceId());
            iconview.setVisibility(View.VISIBLE);
        }
        else
        {
            iconview.setVisibility(View.GONE);
        }

        TextView firstTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        firstTextView.setText(currentword.getmDefaultTranslation());

        TextView secondTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        secondTextView.setText(currentword.getmMiwokTranslation());

        return listItemView;
    }
}
