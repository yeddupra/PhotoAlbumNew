package com.PhotoAlbum;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.PhotoAlbum.Model.MyPhoto;

public class ImageAdapter extends ArrayAdapter<MyPhoto> {
    
    private Context mContext;
    LayoutInflater inflator;
    public ImageAdapter(Context context, int resource) {
    	super(context, resource);    	
     mContext = context; 
     inflator = LayoutInflater.from(context);
    }      
 @Override
 public View getView(int position, View convertView, ViewGroup parent) {
	 LinearLayout itemlayout = null;
	 ImageView imageView;
     itemlayout = (LinearLayout) inflator.inflate(R.layout.item, null);
        	 imageView = (ImageView) itemlayout.findViewById(R.id.thumbnailImageIcon); 
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);      
       MyPhoto ele = (MyPhoto)getItem(position);
       Bitmap bm = null; 
       bm = BitmapFactory.decodeFile(ele.mPath);
       Bitmap ThumbImage = ThumbnailUtils.extractThumbnail(bm, 95, 95);      
       

        imageView.setImageBitmap(ThumbImage);
        return itemlayout;
 }
 
 

}
   
