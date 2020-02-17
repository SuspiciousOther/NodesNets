import java.util.ArrayList;


public class arrayOfNodes {
	private ArrayList<Nodes> arrayNodes;
	
	  	public arrayOfNodes() {
	  		arrayNodes = new ArrayList<Nodes>();
	    }

	    public void addNode(String nodeNameC, double DC , double IC , double EC, double XC, double YC) {
	    	arrayNodes.add(new Nodes(nodeNameC, DC, IC, EC, XC, YC));
	    }

	    public Nodes getNodeAtIndex(int index) {
	        return arrayNodes.get(index);
	    }

	    public int size() {
	        return arrayNodes.size();
	    }	    
	    
	    //or if you want the entire ArrayList:
	    public ArrayList getCustArr() {
	        return arrayNodes;
	    }
}
