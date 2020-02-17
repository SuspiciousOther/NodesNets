

public class bestObject {
	private Nodes node1;
	private Nodes node2;
	private double gain;
	
	  	public bestObject(Nodes node1C, Nodes node2C, double gainC) {
	  		node1 = new Nodes(node1C.getNodeName(), node1C.getD(), node1C.getI(), node1C.getE(), node1C.getX(), node1C.getY());
	  		node2 = new Nodes(node2C.getNodeName(), node2C.getD(), node2C.getI(), node2C.getE(), node2C.getX(), node2C.getY());
	  		gain = gainC;
	    }

		public void setNode1(Nodes myNode){
			this.node1 = myNode;		
		}
		
		public void setNode2(Nodes myNode){
			this.node2 = myNode;		
		}	
		
		public void setGain(double gain){
			this.gain = gain;		
		}		
		
		public Nodes getNode1(){
			return(node1);		
		}
		
		public Nodes getNode2(){
			return(node2);				
		}	
		
		public double getGain(){
			return(gain);			
		}		

}