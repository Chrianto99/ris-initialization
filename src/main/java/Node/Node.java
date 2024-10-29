package Node;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Propagation.*;

public class Node {
	
	public Integer idx;
	public String type;
	public ArrayList<Double> cumulativeDistribution;
	public ArrayList<Ray> rays;
	public boolean isActive;
	public double x,y,z;
	public double size;
	public transient double[] normalVector = new double[]{0,0,0};
	public transient int wall_idx;
	public transient int activeMode;
	public transient boolean[] LOSt,LOSris;
	public transient boolean LOSr;
	public transient double Gt,Gr;
	public transient double transmitPower;
	public transient ArrayList<Integer> allInputLinks;
	public transient ArrayList<Integer> allOutputLinks;

	
	public Node() {

						
	}
	
	public void setPosition(double x, double y,double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		
		
	}
	
	public void print() {
		
		System.out.print("(" + type + "," + wall_idx + "," + idx + ")");
		System.out.println();
		
	}

	
}
