public class Nodes{
	private String nodeName;
	private double D;
	private double I;
	private double E;
	private double X;
	private double Y;

	public Nodes(String nodeNameC, double DC , double IC , double EC, double XC, double YC) {
		nodeName = nodeNameC;
	    D = DC;
	    I = IC;
	    E = EC;
	    X = XC;
	    Y = YC;
	}	
	
	public void genNode(String nameOfNode){
		this.nodeName = nameOfNode;
		this.D = 0;
		this.I = 0;
		this.E = 0;
		this.X = Math.random();
		this.Y = Math.random();
	}

	public String getNodeName(){
		return new String(nodeName.substring(0,2));
	}
	
	public double getD(){
		return D;
	}	
	
	public double getI(){
		return I;
	}
	
	public double getE(){
		return E;
	}
	
	public double getX(){
		return X;
	}
	
	public double getY(){
		return Y;
	}
	
	public void setNodeName(String newName){
		this.nodeName = newName;		
	}	
	
	public void setD(double newD){
		this.D = newD;		
	}
	
	public void setI(double newI){
		this.I = newI;		
	}	
	
	public void setE(double newE){
		this.E = newE;		
	}		
	
	public void setX(double newX){
		this.X = newX;		
	}
	
	public void setY(double newY){
		this.Y = newY;		
	}		


	public String toString(){
			return "\n\nNode Name is: " + getNodeName() + "\nD = " + getD() + "\nI = " + getI() + "\nE = " + getE() + "\nX = " + getX() + "\nY = " + getY();

	}
}