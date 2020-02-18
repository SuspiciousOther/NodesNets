/*
 * mainCode.c
 *
 *  Created on: Feb 12, 2020
 *      Author: smith
 */


import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.util.Collections;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.File; 
import java.util.ArrayList;
import java.util.Scanner;


public class mainCode extends JFrame{
   private static final int Iterations = 97;
   private static final double CanvasX = 800;
   private static final double CanvasY = 600;
   
    public static void plotNode(Graphics g2, Nodes myArrayOfNodes){
      double x = myArrayOfNodes.getX() * (CanvasX-100) + 20;
      double y = myArrayOfNodes.getY() * (CanvasY-100) + 20;
      g2.setColor(new Color((int)(Math.random() * 255), (int)(Math.random()* 255), (int)(Math.random()* 255))); 
      ((Graphics2D) g2).draw(new Ellipse2D.Double((x),(y), 3, 3));
      ((Graphics2D) g2).fill(new Ellipse2D.Double((x),(y), 3, 3));
   }
    
    public static int getCutsize(partitionSetup partition, arrayOfEdges myArrayOfEdges){
 	   int cutSize = 0;
 	   klAlg myKl = new klAlg();    
        int p = myArrayOfEdges.size();
        for (int f = 0; f < p; f++){
           	 cutSize += myKl.checkConnection(partition, myArrayOfEdges.getEdgeAtIndex(f));
        }
        return(cutSize*2);
    }
    
    
//    public static void plotEdges(Graphics g2, Edges myEdge, partitionSetup partition, arrayOfNodes myArrayOfNodes, boolean m){
//      g2.setColor(new Color(0, 0, 0));
//      if (m){
//	      if (myEdge.size() > 2){
//	         int k = myArrayOfNodes.size();
//	         ArrayList<Double> x1 = new ArrayList<>();
//	         ArrayList<Double> y1 = new ArrayList<>();
//	         double x2 = 0;
//	         double y2 = 0;
//	         for (int l = 0; l < k; l++){
//	            int p = myEdge.size();
//	               for (int f = 0; f < p; f++){
//	                  if (myArrayOfNodes.getNodeAtIndex(l).getNodeName().equals(myEdge.getEdgeAtIndex(f))){
//	                     x1.add(myArrayOfNodes.getNodeAtIndex(l).getX()* (CanvasX-100));
//	                     y1.add(myArrayOfNodes.getNodeAtIndex(l).getY()* (CanvasY-100));
//	                     x2 += myArrayOfNodes.getNodeAtIndex(l).getX()* (CanvasX-100);
//	                     y2 += myArrayOfNodes.getNodeAtIndex(l).getY()* (CanvasY-100);
//	                  }
//	               }
//	         }
//	         x2 = x2/x1.size();
//	         y2 = y2/x1.size();
//	         for (int j = 0; j < x1.size(); j++){
//	            ((Graphics2D) g2).draw(new Line2D.Double(x1.get(j)+20,y1.get(j)+20, x2+20, y2+20));
//	         }
//	         
//	      }
//	      else{
//	
//	         int k = myArrayOfNodes.size();
//	         double x1 = 0,y1 = 0,x2 = 0,y2 = 0;
//	         for (int l = 0; l < k; l++){
//	            if (myArrayOfNodes.getNodeAtIndex(l).getNodeName().equals(myEdge.getEdgeAtIndex(0))){
//	               x1 = myArrayOfNodes.getNodeAtIndex(l).getX()* (CanvasX-100);
//	               y1 = myArrayOfNodes.getNodeAtIndex(l).getY()* (CanvasY-100);
//	            }
//	            if (myArrayOfNodes.getNodeAtIndex(l).getNodeName().equals(myEdge.getEdgeAtIndex(1))){
//	               x2 = myArrayOfNodes.getNodeAtIndex(l).getX()* (CanvasX-100);
//	               y2 = myArrayOfNodes.getNodeAtIndex(l).getY()* (CanvasY-100);
//	            }
//	         }
//	         ((Graphics2D) g2).draw(new Line2D.Double(x1+20,y1+20, x2+20, y2+20));
//	      }
//      }
//      else{
//    	  if (myEdge.size() > 2){
// 	         int k = myArrayOfNodes.size();
// 	         ArrayList<Double> x1 = new ArrayList<>();
// 	         ArrayList<Double> y1 = new ArrayList<>();
// 	         double x2 = 0;
// 	         double y2 = 0;
// 	         for (int l = 0; l < k; l++){
// 	            int p = myEdge.size();
// 	               for (int f = 0; f < 7*p/8; f++){
// 	                  if (myArrayOfNodes.getNodeAtIndex(l).getNodeName().equals(myEdge.getEdgeAtIndex(f))){
// 	                	 double seed = Math.random()*800;
// 	                     x1.add(myArrayOfNodes.getNodeAtIndex(l).getX()* (CanvasX-seed));
// 	                     y1.add(myArrayOfNodes.getNodeAtIndex(l).getY()* (CanvasY-100));
// 	                     x2 += myArrayOfNodes.getNodeAtIndex(l).getX()* (CanvasX-seed);
// 	                     y2 += myArrayOfNodes.getNodeAtIndex(l).getY()* (CanvasY-100);
// 	                  }
// 	               }
// 	               for (int f = 7*p/8; f < p; f++){
//  	                  if (myArrayOfNodes.getNodeAtIndex(l).getNodeName().equals(myEdge.getEdgeAtIndex(f))){
//  	                	 double seed = Math.random()*800;
//  	                     x1.add(myArrayOfNodes.getNodeAtIndex(l).getX()* (CanvasX+seed));
//  	                     y1.add(myArrayOfNodes.getNodeAtIndex(l).getY()* (CanvasY-100));
//  	                     x2 += myArrayOfNodes.getNodeAtIndex(l).getX()* (CanvasX+seed);
//  	                     y2 += myArrayOfNodes.getNodeAtIndex(l).getY()* (CanvasY-100);
//  	                  }
// 	               }
// 	         }
// 	         x2 = x2/x1.size();
// 	         y2 = y2/x1.size();
// 	         for (int j = 0; j < x1.size(); j++){
// 	            ((Graphics2D) g2).draw(new Line2D.Double(x1.get(j)+20,y1.get(j)+20, x2+20, y2+20));
// 	         }
// 	         
// 	      }
// 	      else{
// 	
// 	         int k = myArrayOfNodes.size();
// 	         double x1 = 0,y1 = 0,x2 = 0,y2 = 0;
// 	         for (int l = 0; l < k; l++){
// 	            if (myArrayOfNodes.getNodeAtIndex(l).getNodeName().equals(myEdge.getEdgeAtIndex(0))){
// 	               x1 = myArrayOfNodes.getNodeAtIndex(l).getX()* (CanvasX-100);
// 	               y1 = myArrayOfNodes.getNodeAtIndex(l).getY()* (CanvasY-100);
// 	            }
// 	            if (myArrayOfNodes.getNodeAtIndex(l).getNodeName().equals(myEdge.getEdgeAtIndex(1))){
// 	               x2 = myArrayOfNodes.getNodeAtIndex(l).getX()* (CanvasX-100);
// 	               y2 = myArrayOfNodes.getNodeAtIndex(l).getY()* (CanvasY-100);
// 	            }
// 	         }
// 	         ((Graphics2D) g2).draw(new Line2D.Double(x1+20,y1+20, x2+20, y2+20));
// 	      }
//      }
//   }
    
    public static void plotEdges(Graphics g2, Edges myEdge, partitionSetup partition, arrayOfNodes myArrayOfNodes){
        g2.setColor(new Color(0, 0, 0));
  	      if (myEdge.size() > 2){
  	         int k = myArrayOfNodes.size();
  	         ArrayList<Double> x1 = new ArrayList<>();
  	         ArrayList<Double> y1 = new ArrayList<>();
  	         double x2 = 0;
  	         double y2 = 0;
  	         for (int l = 0; l < k; l++){
  	            int p = myEdge.size();
  	               for (int f = 0; f < p; f++){
  	                  if (myArrayOfNodes.getNodeAtIndex(l).getNodeName().equals(myEdge.getEdgeAtIndex(f))){
  	                     x1.add(myArrayOfNodes.getNodeAtIndex(l).getX()* (CanvasX-100));
  	                     y1.add(myArrayOfNodes.getNodeAtIndex(l).getY()* (CanvasY-100));
  	                     x2 += myArrayOfNodes.getNodeAtIndex(l).getX()* (CanvasX-100);
  	                     y2 += myArrayOfNodes.getNodeAtIndex(l).getY()* (CanvasY-100);
  	                  }
  	               }
  	         }
  	         x2 = x2/x1.size();
  	         y2 = y2/x1.size();
  	         for (int j = 0; j < x1.size(); j++){
  	            ((Graphics2D) g2).draw(new Line2D.Double(x1.get(j)+20,y1.get(j)+20, x2+20, y2+20));
  	         }
  	         
  	      }
  	      else{
  	
  	         int k = myArrayOfNodes.size();
  	         double x1 = 0,y1 = 0,x2 = 0,y2 = 0;
  	         for (int l = 0; l < k; l++){
  	            if (myArrayOfNodes.getNodeAtIndex(l).getNodeName().equals(myEdge.getEdgeAtIndex(0))){
  	               x1 = myArrayOfNodes.getNodeAtIndex(l).getX()* (CanvasX-100);
  	               y1 = myArrayOfNodes.getNodeAtIndex(l).getY()* (CanvasY-100);
  	            }
  	            if (myArrayOfNodes.getNodeAtIndex(l).getNodeName().equals(myEdge.getEdgeAtIndex(1))){
  	               x2 = myArrayOfNodes.getNodeAtIndex(l).getX()* (CanvasX-100);
  	               y2 = myArrayOfNodes.getNodeAtIndex(l).getY()* (CanvasY-100);
  	            }
  	         }
  	         ((Graphics2D) g2).draw(new Line2D.Double(x1+20,y1+20, x2+20, y2+20));
  	      }
   }
   
//   public static int getIniCutsize(partitionSetup partition, arrayOfEdges myArrayOfEdges){
//	   int cutSize = 0;
//	   klAlg myKl = new klAlg();    
//       int p = myArrayOfEdges.size();
//       for (int f = 0; f < p; f++){
//    	   for (int j = 0; j < 5; j++){
//          	 cutSize += myKl.checkConnection(partition, myArrayOfEdges.getEdgeAtIndex(f));
//    	   }
//       }
//       return(cutSize);
//   }
    
    public static void drawPartitons(Graphics g2){
      g2.setColor(new Color(127, 137, 153)); 
      ((Graphics2D) g2).draw(new Rectangle2D.Double((CanvasX-(CanvasX - 10)),10, (CanvasX-(CanvasX/2)-50), CanvasY-60));
      ((Graphics2D) g2).draw(new Rectangle2D.Double((CanvasX-(CanvasX/2 + 10)),10, (CanvasX-(CanvasX/2)-50), CanvasY-60));
      ((Graphics2D) g2).draw(new Line2D.Double((CanvasX-(CanvasX/2)-25),5, (CanvasX-(CanvasX/2)-25), CanvasY-45));
   }

    public static void main(String[] args) throws Exception  
     { 
      
      
      new mainCode();
      arrayOfNodes nodesArr = new arrayOfNodes();
      
      //Select Nodes
      
      /*JFileChooser chooserNodes = new JFileChooser();
      FileNameExtensionFilter filterNodes = new FileNameExtensionFilter(
              "nodes files", "txt");
      chooserNodes.setFileFilter(filterNodes);
      int returnVal = chooserNodes.showOpenDialog(null);
      //Select Nets
      
      JFileChooser chooserNets = new JFileChooser();
      FileNameExtensionFilter filterNets = new FileNameExtensionFilter(
              "Net files", "txt");
      chooserNets.setFileFilter(filterNets);
      int returnVal2 = chooserNets.showOpenDialog(null);
      
      //System.out.println(fileNodes + " chosen.");
      File file1 = new File( chooserNodes.getSelectedFile().getAbsolutePath());
      File file2 = new File( chooserNets.getSelectedFile().getAbsolutePath());   */
      File file1 = new File("F:\\Java Workspaces\\PhysDesignA1\\Files\\spp_N193_E227_R11_153.nodes.txt");
      File file2 = new File("F:\\Java Workspaces\\PhysDesignA1\\Files\\spp_N193_E227_R11_153.nets.txt");   
      Scanner sc1 = new Scanner(file1); 
      Scanner sc2 = new Scanner(file2); 
      String s = new String();
      
      int index = 0;
       while (sc1.hasNextLine()){
         s = sc1.nextLine();
            if ( index > 6 ){
            nodesArr.addNode(s, 0, 0, 0, Math.random(), Math.random());
            }
            index++;
       } 
       
       //System.out.println(nodesArr.getCustArr());
       ArrayList<String> nodesArr2 = new ArrayList<String>();
       arrayOfEdges EdgesArr = new arrayOfEdges();
      index = 0;
      int j = 0; //Net Degree
      int k = 0;
      
      
       while (sc2.hasNextLine()){
         s = sc2.nextLine();
            if ( index > 5){
            if (s.length() > 11){
               j = Integer.parseInt(s.substring(12));
               //System.out.println(s.substring(12));
               //System.out.println("J = " + j);
               nodesArr2 = new ArrayList<String>();
               k = 0;
            }
            else{
               if (k < j){
                  nodesArr2.add(s.substring(0,s.length()-2));
                  //System.out.println(nodesArr2);
                  k++;
                  if (k == j){
                     EdgesArr.addEdge(nodesArr2, 1);
                     //System.out.println(EdgesArr.getCustArr());
                  }
               }
            }
            }
            index++;
       }
       
       //Phase 1: Creating Initial Partition 
       partitionSetup partition = new partitionSetup();
       for (int l = 0; l < nodesArr.size(); l++){
         if ((l & 1) == 0){
            partition.addNode(nodesArr.getNodeAtIndex(l),nodesArr.getNodeAtIndex(l).getX(), nodesArr.getNodeAtIndex(l).getY(), 0);
         }
         else{
            partition.addNode(nodesArr.getNodeAtIndex(l),nodesArr.getNodeAtIndex(l).getX(), nodesArr.getNodeAtIndex(l).getY(), 1);
         }
       }
       JFrame frame1 = new JFrame("Initial Partition");     
       frame1.add(new JPanel()
       {
         
         public void paint(Graphics g)
         {
           super.paint(g);
           Graphics2D g2 = (Graphics2D) g;
          int k = nodesArr.size();
          for (int l = 0; l<k; l++){
            plotNode(g2, nodesArr.getNodeAtIndex(l));
          }
          
          k = EdgesArr.size();
          for (int l = 0; l<k; l++){
            plotEdges(g2, EdgesArr.getEdgeAtIndex(l), partition, nodesArr);
          }           
          g2.setColor(new Color(0, 0, 0));
          g2.setFont(new Font("Purisa", Font.PLAIN, 25));
          g2.drawString("Initial Partition", 20, (int)CanvasY - 25);
          g2.drawString("Initial Cutsize:  " + getCutsize(partition, EdgesArr), 20, (int)CanvasY+10);
          drawPartitons(g2);
         }
       });
      frame1.setSize((int)CanvasX-30, (int)CanvasY + 100); 
      frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame1.setVisible(true);    
      frame1.repaint();
       //End Phase 1
      
       
       
       
      
      //Phase 2: Creating Optimized Partition 
      
      partitionSetup optimizedPartition = partition.makeDeepCopyPartition(partition);        //Create Deep Copy of Old Partition
      ArrayList<Double> gainIteration = new ArrayList<>();                                   //How much gain happened at the iteration
      arrayOfNodes gainNodes1Iteration = new arrayOfNodes(); 								 //Which nodes were swapped
      arrayOfNodes gainNodes2Iteration = new arrayOfNodes(); 								 //Which nodes were swapped
      klAlg myKl = new klAlg();                                                              //Create new klAlgorithm Object
      bestObject bestCurrent = new bestObject(new Nodes("null",0,0,0,0,0),new Nodes("null",0,0,0,0,0),0);
      for (int x = 0; x<Iterations; x++){
	      for (int l = 0; l<optimizedPartition.partition0.size(); l++){                          //Calculate Parameters for partition0
	         double myParameterArray[] = myKl.getNodeParameters(optimizedPartition, optimizedPartition.getNodeAtIndex(0, l), EdgesArr);
	         optimizedPartition.getNodeAtIndex(0, l).setI(myParameterArray[0]);
	         optimizedPartition.getNodeAtIndex(0, l).setE(myParameterArray[1]);
	         optimizedPartition.getNodeAtIndex(0, l).setD(myParameterArray[2]);
	      }
	      
	      for (int l = 0; l<optimizedPartition.partition1.size(); l++){                          //Calculate Parameters for partition1
	         double myParameterArray[] = myKl.getNodeParameters(optimizedPartition, optimizedPartition.getNodeAtIndex(1, l), EdgesArr);
	         optimizedPartition.getNodeAtIndex(1, l).setI(myParameterArray[0]);
	         optimizedPartition.getNodeAtIndex(1, l).setE(myParameterArray[1]);
	         optimizedPartition.getNodeAtIndex(1, l).setD(myParameterArray[2]);
	      }      
	      partitionSetup iteratedPartition = partition.makeDeepCopyPartition(optimizedPartition);        //Create Deep Copy of Old Partition for nodes not optimized
	      double storeImprovement = 0;
	      bestCurrent.setGain(0);
	      double myG = 0;
	      for (int l = 0; l<iteratedPartition.partition0.size(); l++){ //iteratedPartition.partition0.size()
	    	  //System.out.println("l = " + l);   
	    	  for (int m = 0; m<iteratedPartition.partition1.size(); m++){ //iteratedPartition.partition1.size()
	    		  //System.out.println(iteratedPartition.getNodeAtIndex(1, m));  
	    		  //System.out.println("Optmized Size = " + optimizedPartition.partition1.size());  
	    		  //System.out.println("Iterated Size = " + iteratedPartition.partition1.size());  
	    		  //System.out.println("m = " + m);   
	    		  myG = iteratedPartition.getNodeAtIndex(0, l).getD() + iteratedPartition.getNodeAtIndex(1, m).getD() - 2*myKl.getCost(iteratedPartition.getNodeAtIndex(0, l).getNodeName(), iteratedPartition.getNodeAtIndex(1, m).getNodeName(), EdgesArr);
	    		 //System.out.println(myG);
	    		  if (bestCurrent.getGain() < myG || bestCurrent.getNode1().getNodeName().equals("null")){
	    			  bestCurrent.setNode1(iteratedPartition.getNodeAtIndex(0, l));
	    			  bestCurrent.setNode2(iteratedPartition.getNodeAtIndex(1, m));
	    			  bestCurrent.setGain(myG);
	    		  }
	    	  }
	      }
	      		  System.out.println(bestCurrent.getNode1());
			      iteratedPartition.removeNode(bestCurrent.getNode1(), iteratedPartition, iteratedPartition.partition0, 0);
			      iteratedPartition.removeNode(bestCurrent.getNode2(), iteratedPartition, iteratedPartition.partition1, 1);

			      System.out.println("x = " + x);
			      System.out.println(iteratedPartition);
			      storeImprovement += bestCurrent.getGain();
			      gainIteration.add(storeImprovement);
			      //gainNodes1Iteration.addNode(bestCurrent.getNode1().getNodeName(),bestCurrent.getNode1().getD(),bestCurrent.getNode1().getI(), bestCurrent.getNode1().getE(), bestCurrent.getNode1().getX(), bestCurrent.getNode1().getY());
			      //gainNodes2Iteration.addNode(bestCurrent.getNode2().getNodeName(),bestCurrent.getNode2().getD(),bestCurrent.getNode2().getI(), bestCurrent.getNode2().getE(), bestCurrent.getNode2().getX(), bestCurrent.getNode2().getY());
			      //System.out.println("Iteration = " + x);
			      //System.out.println(bestCurrent.getNode1());
			      //myKl.interchange(bestCurrent.getNode1(), bestCurrent.getNode2(), optimizedPartition);
	       	  
			      for (int f = 0; f<optimizedPartition.partition0.size(); f++){                          //Calculate Parameters for partition0
			          double myParameterArray[] = myKl.getNodeParameters(optimizedPartition, optimizedPartition.getNodeAtIndex(0, f), EdgesArr);
			          optimizedPartition.getNodeAtIndex(0, f).setI(myParameterArray[0]);
			          optimizedPartition.getNodeAtIndex(0, f).setE(myParameterArray[1]);
			          optimizedPartition.getNodeAtIndex(0, f).setD(myParameterArray[2]);
			       }
			       
			       for (int f = 0; f<optimizedPartition.partition1.size(); f++){                          //Calculate Parameters for partition1
			          double myParameterArray[] = myKl.getNodeParameters(optimizedPartition, optimizedPartition.getNodeAtIndex(1, f), EdgesArr);
			          optimizedPartition.getNodeAtIndex(1, f).setI(myParameterArray[0]);
			          optimizedPartition.getNodeAtIndex(1, f).setE(myParameterArray[1]);
			          optimizedPartition.getNodeAtIndex(1, f).setD(myParameterArray[2]);
			       }
	    	  
	      //System.out.println("3");
	      double maxGain = Collections.max(gainIteration);
	      int indexMax = gainIteration.indexOf(Collections.max(gainIteration));
	      
	      for (int l = 0; l<indexMax; l++){
	    	  //myKl.interchange(gainNodes1Iteration.getNodeAtIndex(l),gainNodes2Iteration.getNodeAtIndex(l),optimizedPartition);
	      }	      
      }
            
      //End Phase 2
       
       JFrame frame = new JFrame("Final Partition");     
       frame.add(new JPanel()
       {
         
         public void paint(Graphics g)
         {
           super.paint(g);
           Graphics2D g2 = (Graphics2D) g;
          int k = optimizedPartition.partition1.size();
          for (int l = 0; l<k; l++){
        	//System.out.println("l = " + l);
        	//System.out.println("Node1: =" + optimizedPartition.getNodeAtIndex(0,l));
        	//System.out.println("Node2: =" + optimizedPartition.getNodeAtIndex(1,l));
            plotNode(g2, optimizedPartition.getNodeAtIndex(0,l));
            plotNode(g2, optimizedPartition.getNodeAtIndex(1,l));
          }
          
          k = EdgesArr.size();
          for (int l = 0; l<k; l++){
            //plotEdges(g2, EdgesArr.getEdgeAtIndex(l), optimizedPartition, nodesArr);
          }           
          g2.setColor(new Color(0, 0, 0));
          g2.setFont(new Font("Purisa", Font.PLAIN, 25));
          g2.drawString("Final Partition", 20, (int)CanvasY - 25);
          g2.drawString("Final Cutsize:  " + getCutsize(optimizedPartition, EdgesArr), 20, (int)CanvasY+10);
          drawPartitons(g2);
         }
       });
      frame.setSize((int)CanvasX-30, (int)CanvasY + 100); 
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);    
      frame.repaint();
       
       //System.out.println(EdgesArr.getCustArr());
     }   
    
}

