package yandex;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;

import org.json.*;

public class Googleplaceinformation {

	
	 
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		try {  
			
			
			HttpRequester request = new HttpRequester();  
            HttpRespons places = request.sendGet("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&sensor=false&key=AIzaSyBfabEhnLqkBBVW227v6ALE0VYZGTUK5FQ");              
            
          //  HttpRespons references = request.sendGet("https://maps.googleapis.com/maps/api/place/details/json?reference="+firenferce[1]+"&sensor=false&key=AIzaSyBfabEhnLqkBBVW227v6ALE0VYZGTUK5FQ");    
    	  //  System.out.print(references.getContent());                  
            


            JSONObject jsonObject = new JSONObject(places.getContent()) ;     
            JSONArray jsonArrayResult = jsonObject.getJSONArray("results");
            
            String[] putrenferce = new String[100];
       
            FileWriter fw2= new FileWriter("F:\\referebce.txt");
            
             for(int i = 0; i < jsonArrayResult.length(); i++ )
             {
        	   
        	   	JSONObject jsonObjectResult = jsonArrayResult.getJSONObject(i);
            //    System.out.println(jsonObjectResult.get("reference"));
        	    if  ((String)jsonObjectResult.get("reference")!=null)
        	    {
           	     putrenferce[i] = (String)jsonObjectResult.get("reference");
        	    }
        	           	   
             }     	
             
             for (int j = 0; j < putrenferce.length; j++)
               {
 				 if (putrenferce[j].equals(null) ){
 					 putrenferce[j] = "#";
				}
            	// System.out.println(putrenferce[j]);			
         	     HttpRespons references = request.sendGet("https://maps.googleapis.com/maps/api/place/details/json?reference="+putrenferce[j]+"&sensor=false&key=AIzaSyBejfN8dyxCH-l3u7cQ-sq7jHtLh7--qH4");    
         	    // System.out.print(references.getContent());   
         	     JSONObject jsonObject2 = new JSONObject(references.getContent()) ; 
         	 //    JSONObject jsonObject3 =  jsonObject2.getJSONObject("rating");
         	     JSONArray jsonArray2= jsonObject2.getJSONArray("rating");
         	    
         	    for(int k = 0; k < jsonArray2.length(); k++ )
                {          	   
         	     JSONObject jsonObjectResult2 =jsonArray2.getJSONObject(k).getJSONObject("rating");   	     
                 System.out.println(jsonArray2.getJSONObject(k).getJSONObject("rating"));
                }  
               
               }
 } 
		 
		catch (Exception e)
		    {  
                e.printStackTrace();  
            }  
	
		
	
	
	}

}
