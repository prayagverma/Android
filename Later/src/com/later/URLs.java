package com.later;

import java.net.MalformedURLException;
import java.net.URL;


public class URLs {
    
     String _id;
    URL _url;
    String _title;
    
     
     public URLs(){
         
    }
     public URLs( URL url,String title){
         
        this._url = url;
        this._title = title;
         
    }
    
     public String getTitle(){
         return this._title;
     }
      
   
     public void setTitle(String title){
    	 this._title = title;
     }
   
    public String getID(){
        return this._id;
    }
     
  
    public void setID(String id){
        this._id = id;
    }
     
   
    public URL getName(){
        return this._url;
    }
     
     
    public void setName(String url){
    	URL u;
		try {
			u = new URL(url);
		
        this._url =u;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
     
    
 
}