package com.PhotoAlbum.Model;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.media.ExifInterface;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;

public class LoadImageData extends AsyncTask<Void, Long, Boolean> {
  
	private String mDirectoryPath; 
	ArrayAdapter myAdapter;
	Activity mActivity;
    public LoadImageData(Activity activity,ArrayAdapter adapter,String directoryPath) {
    	mActivity =activity;
		myAdapter = adapter;
        mDirectoryPath = directoryPath;
    }

    @Override
    protected Boolean doInBackground(Void... params) {    	
        try {  
                  File targetDirector = new File(mDirectoryPath);                  
                  File[] files = targetDirector.listFiles();
                  for (final File file : files){                	 
                	  mActivity.runOnUiThread(new Runnable() 
                	    {
                	        public void run() 
                	        {
                	        	ExifInterface exifInterface = null;
								try {
									exifInterface = new ExifInterface(file.toString());
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
               	        	 
                	        	String  latitude = exifInterface.getAttribute(ExifInterface.TAG_GPS_LATITUDE) == null?"":exifInterface.getAttribute(ExifInterface.TAG_GPS_LATITUDE); 
                	        	//String  latitude = exifInterface.getAttribute(ExifInterface.TAG_GPS_LATITUDE_REF); 
                	        	String  longitude = exifInterface.getAttribute(ExifInterface.TAG_GPS_LONGITUDE)== null ? "": exifInterface.getAttribute(ExifInterface.TAG_GPS_LONGITUDE); 
                	        	//String  latitude = exifInterface.getAttribute(ExifInterface.TAG_GPS_LONGITUDE_REF); 
                	        	
                	        	MyPhoto myPhoto = new MyPhoto(file.lastModified(),latitude + ", "+longitude,file.getAbsolutePath());
                	        	myAdapter.add(myPhoto);
                	        	//myAdapter.notifyDataSetChanged();
                	        }
                	    });               	
                	  
                  } 
            return true;

        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {            
        }
        return false;
    }

 
    @Override
    protected void onPostExecute(Boolean result) {       
        if (result) 
        {    
        	
        } 
        else 
        {

        }
    }   
}
