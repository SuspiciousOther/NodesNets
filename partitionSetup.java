import java.util.ArrayList;


public class partitionSetup {
	
	public ArrayList<Nodes> partition0;
	public ArrayList<Nodes> partition1;
	
  	public partitionSetup() {
  		partition0 = new ArrayList<Nodes>();
  		partition1 = new ArrayList<Nodes>();
    }
  	
  	public partitionSetup(ArrayList<Nodes> a1, ArrayList<Nodes> a2) {
  		partition0 = new ArrayList<Nodes>(a1);
  		partition1 = new ArrayList<Nodes>(a2);
    }
  	
  	public partitionSetup(partitionSetup partition) {
  		this.partition0 = new ArrayList<Nodes>(partition.partition0);
  		this.partition1 = new ArrayList<Nodes>(partition.partition0);
    }  	
  	
  	public static partitionSetup makeDeepCopyPartition(partitionSetup partition){
  	    ArrayList<Nodes> arrCopy1 = new ArrayList<Nodes>();
  	    ArrayList<Nodes> arrCopy2 = new ArrayList<Nodes>();
  	    for(Nodes i : partition.partition0){
  	    	arrCopy1.add(new Nodes(i.getNodeName(), i.getD(), i.getI(), i.getE(), i.getX(), i.getY()));
  	    }
  	    for(Nodes i : partition.partition1){
  	    	arrCopy2.add(new Nodes(i.getNodeName(), i.getD(), i.getI(), i.getE(), i.getX(), i.getY()));
  	    }
  	    return new partitionSetup(arrCopy1, arrCopy2);
  	}
  	
    public Nodes getNodeAtIndex(int partition, int index) {
        if (partition == 0){
        	return partition0.get(index);
        }
        else{
        	return partition1.get(index);
        }
    }
    public void addNode(String nodeNameC, float DC , float IC , float EC, double XC, double YC, int CanvasX) {
    	if(XC < (CanvasX-(CanvasX/2)-25)){
    		partition0.add(new Nodes(nodeNameC, DC, IC, EC, XC, YC));
    	}
    	else{
    		partition1.add(new Nodes(nodeNameC, DC, IC, EC, XC, YC));
    	}
    }
    
    public void addNode(Nodes myNode,double newX, double newY, int Section) {
    	
    	if(Section == 0){
    		partition0.add(new Nodes(myNode.getNodeName(), myNode.getD() , myNode.getI() , myNode.getE() , newX , newY ));
    	}
    	else{
    		partition1.add(new Nodes(myNode.getNodeName(), myNode.getD() , myNode.getI() , myNode.getE() , newX , newY ));
    	}
    }    
    
    public void removeNode(Nodes myNode, partitionSetup partition, ArrayList<Nodes> partitionArea, int partitionNum){
    	int myIndex = 0;
    	for (int index = 0; index < partitionArea.size(); index++){
    		//System.out.println(partition.getNodeAtIndex(partitionNum, index).getNodeName());
    		//System.out.println(myNode.getNodeName());
    		 if(partition.getNodeAtIndex(partitionNum, index).getNodeName().equals(myNode.getNodeName())){
    			 //System.out.println("enter");
    			 myIndex = index;
    		 }
    	}
		 if (partitionNum == 0){
			 partition.partition0.remove(myIndex);
			 //System.out.println("deleted");
		 }
		 else{
			 partition.partition1.remove(myIndex);
			 //System.out.println("deleted");
		 }
    }
    
    public String returnPartition(partitionSetup partition, String nameOfNode){ //always pass in partition 1
    	for (int i = 0; i<partition.partition0.size(); i++){
        	if (partition.getNodeAtIndex(0,i).getNodeName().equals(nameOfNode)){
        		return "p1";
        	}	
    	}
    		return "p2";
    }

}
