package com.PhotoAlbum;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.PhotoAlbum.Model.LoadImageData;

public class MainActivity extends Activity implements OnItemClickListener{     
   

    ImageAdapter myImageAdapter;
    private final String PHOTO_DIR = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Photos/";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setOnItemClickListener(this);
        myImageAdapter = new ImageAdapter(this, R.layout.item);
        gridview.setAdapter(myImageAdapter); 
        LoadImageData loadImageData = new LoadImageData(MainActivity.this,myImageAdapter,PHOTO_DIR);		
        loadImageData.execute();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();       
    }
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(MainActivity.this,ImageDetailsActivity.class);
		intent.putExtra("ImagePath", myImageAdapter.getItem(arg2).mPath);
		intent.putExtra("ModifiedDate", myImageAdapter.getItem(arg2).mLastModified);
		intent.putExtra("Location", myImageAdapter.getItem(arg2).mLocation);
		startActivity(intent);
	}
}
