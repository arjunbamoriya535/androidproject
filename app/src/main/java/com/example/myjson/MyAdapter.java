package com.example.myjson;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Tutorial> {
    //the tutorial list that will be displayed
    private List<Tutorial> tutorialList;
    private Bitmap bitmap;
    private Context mCtx;
    //here we are getting the tutoriallist and context
    //so while creating the object of this adapter class we need to give tutoriallist and context
    public MyAdapter(List<Tutorial> tutorialList, Context mCtx) {
        super(mCtx, R.layout.list_item, tutorialList);
        this.tutorialList = tutorialList;
        this.mCtx = mCtx;
    }

    //this method will return the list item
    @Override
    public View getView( int position, View convertView, ViewGroup parent) {
        //getting the layoutinflater
        ViewHolder holder;
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        convertView = inflater.inflate(R.layout.list_item, null, true);
        holder = new ViewHolder();
        //getting text views
        holder.textViewName = convertView.findViewById(R.id.textViewName);
        holder.textDescription = convertView.findViewById(R.id.textViewImageUrl);
        holder.imageView = convertView.findViewById(R.id.imageView);

        convertView.setTag(holder);
        //Getting the tutorial for the specified position
        Tutorial tutorial = tutorialList.get(position);
        String imageUrl = tutorial.getImageUrl();
        String tutorialDescription = tutorial.getDescription();
        String tutorialTitle = tutorial.getName();

        holder.textViewName.setText(tutorialTitle);
        holder.textDescription.setText(tutorialDescription);

        if (holder.imageView != null) {
            /*-------------fatching image------------*/;
            new ImageDownloaderTask(holder.imageView).execute(imageUrl);
        }
        holder.imageView.setImageBitmap(bitmap);
        return convertView;
    }
    static class ViewHolder {
        TextView textViewName;
        TextView textDescription;
        ImageView imageView;
    }
}