package Graph;

public class Ris {
	
	double x,y,z;
	int numberOfElements;
	double element_size;
	int idx;
	boolean LOSt,LOSr;
	
	public Ris(int numberOfElements, double element_size, int idx) {
		this.numberOfElements = numberOfElements;
		this.element_size = element_size;
		this.idx = idx;
	}
	
	public void setLOS(boolean LOSr) {

		this.LOSr = LOSr;
	}
	
	public void setPosition(double x,double y,double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
