import java.io.File;
import java.io.FileNotFoundException; 
import java.io.PrintWriter; 
import java.util.LinkedHashMap; 
import java.util.Map; 
import java.util.Scanner;

import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
  
public class jsonWrite 
{ 
	
	public JSONObject jo = new JSONObject(); 
	public JSONArray myNodeArray = new JSONArray(); 
	public Map myNode = new LinkedHashMap(); 
	
		public void genNode() throws FileNotFoundException{
				File file = new File("F:\\Java Workspaces\\PhysDesignA1\\Files\\spp_N193_E227_R11_153.nodes.txt");   
			  	Scanner sc = new Scanner(file); 
			  	String s = new String();
			  	int index = 0;
			    while (sc.hasNextLine()){
			    	s = sc.nextLine();
				      if ( index > 6 ){
				  		myNode = new LinkedHashMap(5); 
						myNode.put("Name", s); 
						myNode.put("D", null);
						myNode.put("I", null);
						myNode.put("E", null);
						myNode.put("X", Math.random()); 
						myNode.put("Y", Math.random()); 
						myNodeArray.add(myNode); 
				      }
				      index++;
			    }
			    
			jo.put(s, myNodeArray); 
	        PrintWriter pw = new PrintWriter("JSONNode.json"); 
	        pw.write(jo.toJSONString()); 
	        
	        pw.flush(); 
	        pw.close();
	        System.out.println("JSON Created!");
		}

} 