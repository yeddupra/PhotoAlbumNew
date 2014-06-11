package com.PhotoAlbum.Model;

public class MyPhoto {
    
    public long mLastModified;
    public String mLocation;
    public String mPath;
    public MyPhoto(){
        
    }
   
    public MyPhoto(long aLastModified, String aLocation, String aPath) {      
    	
    	this.mLastModified = aLastModified;
    	this.mLocation = aLocation;    
    	this.mPath =aPath;
    }
}
