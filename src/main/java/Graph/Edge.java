package Graph;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import Node.*;
public class Edge {

	public int idx;
	public int start_idx;
	public int end_idx;
	public double length;
	public double pathLoss;
	public boolean blocked;
	public int blockPosition;
	
	public transient Node start;
	public transient Node end;
	public transient Integer weight;
	public transient int opacity;
	
	
	public Edge(Node start,Node end,int idx,double length) {
		weight = 1;
		opacity = 128;
		this.start = start;
		this.end = end;
		this.idx = idx;
		this.length = length;
		this.start_idx = start.idx;
		this.end_idx = end.idx;
		
	}
	
	public boolean isParallel(Edge e) {
		Node start = e.start;
		Node end = e.end;
		
		if (this.start.equals(end) && this.end.equals(start)) {
			return true;
		}
		
		return false;
		
	}
	
	public Edge clone(){
		
		Edge e = new Edge(this.start,this.end,this.idx,this.length);
		e.weight = this.weight;
		return e;
		
	}
	
	public void print() {
		
		System.out.print("[L" + idx);
	
		System.out.print("--->" + weight);
		System.out.println();
		
		
	}

	
	public void drawArrow(Graphics2D g2,int x , int y, double angle,double arrowAngle,int length) {
		
		double angle1 = angle + arrowAngle + Math.PI;
		
		
		int x1 = x + (int)(Math.cos(angle1)*length);
		int y1 = y + (int)(Math.sin(angle1)*length);
		g2.drawLine(x, y, x1, y1);
		
		double angle2 = angle1 - 2*arrowAngle;
		int x2 = x + (int)(Math.cos(angle2)*length);
		int y2 = y + (int)(Math.sin(angle2)*length);
		g2.drawLine(x, y, x2, y2);
		
		g2.drawLine(x1,y1,x2,y2);
		
				
		
		
		
		
	}

}
