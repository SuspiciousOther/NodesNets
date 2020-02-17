public class klAlg {
	private double cost = 0;
	public double[] getNodeParameters(partitionSetup partition, Nodes node, arrayOfEdges arrEdges){
	   double myArray[] = {0,0,0}; // D, E, I
		for (int i = 0; i < 2; i++){ //partition.partition0.size()
			for (int j = 0; j < 2; j++){
				if (partition.partition0.contains(node)){			
					if (!node.getNodeName().equals(partition.getNodeAtIndex(j,i).getNodeName())){ //if the nodes are not equal
					   myArray[0]  += (node.getI() + getCost(node.getNodeName(),partition.getNodeAtIndex(0,i).getNodeName(), arrEdges));
					   //System.out.println(myArray[0]);
					}
				}
				else {
					if (!node.getNodeName().equals(partition.getNodeAtIndex(j,i).getNodeName())){ //if the nodes are not equal
						myArray[1] += (node.getE() + getCost(node.getNodeName(),partition.getNodeAtIndex(0,i).getNodeName(), arrEdges));
					}
				}
			}
		}
		myArray[2] = myArray[1] - myArray[0];
		return(myArray);
	}
	
	public int checkConnection(partitionSetup partition, Edges myEdge){
		boolean flag_p1 = false;
		boolean flag_p2 = false;
		int size = 0;
		for (int i = 0; i< myEdge.size(); i++){
			if (partition.returnPartition(partition, myEdge.getEdgeAtIndex(i)).equals("p1")){
				flag_p1 = true;
			}
			if (partition.returnPartition(partition, myEdge.getEdgeAtIndex(i)).equals("p2")){
				flag_p2 = true;
			}
			if (flag_p1 && flag_p2) {
				size += 1;
				flag_p1 = false;
				flag_p2 = false;
			}
		}
		return (size*2);
	}
	
	public void interchange(Nodes node1, Nodes node2, partitionSetup partition){
		double newX1 = node2.getX();
		double newX2 = node1.getX();
		double newY1 = node2.getY();
		double newY2 = node1.getY();

			partition.addNode(node1,newX1, newY1, 1);
			partition.removeNode(node1, partition, partition.partition0,0);
			partition.addNode(node2,newX2, newY2, 0);
			partition.removeNode(node2, partition, partition.partition1,1);


	}
	
	public double getCost(String nodeOne, String nodeTwo, arrayOfEdges arrayEdges){
		cost = 0;
		for (int i = 0; i < arrayEdges.size(); i++){
			if (arrayEdges.getEdgeAtIndex(i).getEdge().contains(nodeOne) && arrayEdges.getEdgeAtIndex(i).getEdge().contains(nodeTwo)){
				cost += arrayEdges.getEdgeAtIndex(i).getWeight() / (arrayEdges.size()-1);
			}
		}
		return cost;
	}
	
}
