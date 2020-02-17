import java.util.ArrayList;

public class Edges{
	private ArrayList<String> nodesInEdge;
	private float weight;


	public Edges(ArrayList<String> nodesInEdgeC, float weightC) {
		nodesInEdge = nodesInEdgeC;
	    weight = weightC;
	}	
		
	public ArrayList getEdge(){
		return nodesInEdge;
	}	
	
    public String getEdgeAtIndex(int index) {
        return nodesInEdge.get(index);
    }	
    
    public int size() {
        return nodesInEdge.size();
    }	    
	
	public float getWeight(){
		return weight;
	}	

	public String toString(){
			return "\n\nNodes in Edge is: " + getEdge() + "\nWeight = " + getWeight();

	}
}