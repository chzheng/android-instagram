package com.example.chzheng.instagramclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by chzheng on 12/2/2015.
 */
public class InstagramPhotosAdapter extends ArrayAdapter<InstagramPhoto> {

    // need context & data source
    public InstagramPhotosAdapter(Context context, List<InstagramPhoto> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
    }

    // use the template to display each photo

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        InstagramPhoto photo = getItem(position);

        // Check if we are using a recycled view, if not we need to inflate
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
        }

        // Lookup the views for populating the data (image, caption)
        TextView tvCaption = (TextView) convertView.findViewById(R.id.tvCaption);
        ImageView lvPhoto = (ImageView) convertView.findViewById(R.id.ivPhoto);

        // Insert the model into each of the view items
        tvCaption.setText(photo.caption);

        // clear recycled image
//        lvPhoto.setImageResource(0);
        // download image from internet into imageView
        Picasso.with(getContext()).load(photo.imageUrl).into(lvPhoto);

        // Return the created item as a view
        return convertView;
    }
}
