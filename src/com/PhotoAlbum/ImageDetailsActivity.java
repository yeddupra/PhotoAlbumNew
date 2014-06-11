package com.PhotoAlbum;



import java.util.Date;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.TextView;


public class ImageDetailsActivity extends Activity {     
   

    ImageAdapter myImageAdapter;
    private final String PHOTO_DIR = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Photos/";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photodetail);
        
        ImageView imageView = (ImageView) findViewById(R.id.detailImageView);        
        imageView.setImageBitmap(BitmapFactory.decodeFile(getIntent().getStringExtra("ImagePath")));
        TextView modifiedDate = (TextView) findViewById(R.id.ModifiedDate);   
        Date dt = new Date();
        dt.setTime(getIntent().getLongExtra("ModifiedDate",0));
        modifiedDate.setText(dt.toString());
        TextView location = (TextView) findViewById(R.id.Location);        
        location.setText(getIntent().getStringExtra("Location"));
    }
    
    
}
