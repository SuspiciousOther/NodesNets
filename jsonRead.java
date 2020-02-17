// Java program to read JSON from a file 
  
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader; 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator; 
import java.util.LinkedHashMap;
import java.util.Map; 
  
import java.util.Scanner;

import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*; 
  
public class jsonRead 
{ 
	
	public void readNode() throws IOException, ParseException{
        // parsing file "JSONExample.json" 
        Object obj = new JSONParser().parse(new FileReader("JSONNode.json")); 
          
        // typecasting obj to JSONObject 
        JSONObject jo = (JSONObject) obj; 
                   
        // getting address 
        Map address = ((Map)jo.get("Name")); 
          
        // iterating address Map 
        Iterator<Map.Entry> itr1 = address.entrySet().iterator(); 
        while (itr1.hasNext()) { 
            Map.Entry pair = itr1.next(); 
            System.out.println(pair.getKey() + " : " + pair.getValue()); 
        } 
          
        // getting phoneNumbers 
        JSONArray myNodeArray = (JSONArray) jo.get("a1"); 
          
        // iterating phoneNumbers 
        Iterator itr2 = myNodeArray.iterator(); 
          
        while (itr2.hasNext())  
        { 
            itr1 = ((Map) itr2.next()).entrySet().iterator(); 
            while (itr1.hasNext()) { 
                Map.Entry pair = itr1.next(); 
                System.out.println(pair.getKey() + " : " + pair.getValue()); 
            } 
        } 
	    System.out.println("JSON Opened!");
	}	

} 