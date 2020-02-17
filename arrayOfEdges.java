import java.util.ArrayList;


public class arrayOfEdges {
	private ArrayList<Edges> arrayEdges;
	
	  	public arrayOfEdges() {
	  		arrayEdges = new ArrayList<Edges>();
	    }

	    public void addEdge(ArrayList<String> nodeNameC, float weightC) {
	    	arrayEdges.add(new Edges(nodeNameC, weightC));
	    }

	    public Edges getEdgeAtIndex(int index) {
	        return arrayEdges.get(index);
	    }

	    public int size() {
	        return arrayEdges.size();
	    }	    	    
	    
	    //or if you want the entire ArrayList:
	    public ArrayList getCustArr() {
	        return arrayEdges;
	    }
}
