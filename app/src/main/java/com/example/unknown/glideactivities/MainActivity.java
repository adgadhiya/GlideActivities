package com.example.unknown.glideactivities;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView view = (ImageView)findViewById(R.id.image_view);

        String[] images = {

                "http://i.imgur.com/rFLNqWI.jpg",
                "http://i.imgur.com/C9pBVt7.jpg",
                "http://i.imgur.com/rT5vXE1.jpg",
                "http://i.imgur.com/MoJs9pT.jpg",
                "http://i.imgur.com/s963yEM.jpg",
                "http://i.imgur.com/SEPdUIx.jpg",
                "http://i.imgur.com/fUX7EIB.jpg"
        };


        GridView listView = (GridView) findViewById(R.id.lv);

        int i = R.mipmap.ntitled;
        Glide.with(this).load(i).into(view);

        // File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"Name Of Image.png");
        //Glide.with(this).load(file).into(view);

       // String URL = "http://i.imgur.com/DvpvklR.png";
        //Glide.with(this).load(URL).into(view);

       // Uri uri = Uri.parse("android.resource://" + this.getPackageName() + "/" + R.mipmap.a8);
       // Glide.with(this).load(uri).into(view);

      //  listView.setAdapter(new ImageListAdapter(MainActivity.this,images));

    }

    public class ImageListAdapter extends ArrayAdapter {

        Context context;
        String[] resource;
        LayoutInflater inflater;

        public ImageListAdapter(Context context, String[] resource) {
            super(context,R.layout.items,resource);

            this.context = context;
            this.resource = resource;

            inflater = LayoutInflater.from(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = convertView;

            if(view == null){
                view = inflater.inflate(R.layout.items,parent,false);
            }

            ImageView imageView = (ImageView) view.findViewById(R.id.iv);

            Glide.with(context).load(resource[position])
                    .placeholder(R.mipmap.ic_launcher)
                    .error(android.R.drawable.stat_notify_error)
                    .crossFade()
                    .into(imageView);

            return view;

        }
    }

}
