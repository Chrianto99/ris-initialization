package RoomGeometry;

public class Surface {

    private String type;
    private double area;
    private int numberOfTiles;
    private double[] n, v, u;
    private double A, B, C, D;
    private double[] xLims, yLims, zLims;


    public Surface() {
    }

    public void setCoefficients(double A, double B, double C, double D) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;

    }

    public void setLimits(double[] xLims, double[] yLims, double[] zLims) {
        this.xLims = xLims;
        this.yLims = yLims;
        this.zLims = zLims;
    }

    public void initializeSurfaceXY(double[] xLims, double[] yLims, double offset) {
        type = "XY";
        setCoefficients(0, 0, 1, offset);
        n = new double[]{0, 0, 1};
        v = new double[]{0, 1, 0};
        u = new double[]{1, 0, 0};
        setLimits(xLims, yLims, null);
        computeArea();


    }

    public void initializeSurfaceXZ(double[] xLims, double[] zLims, double offset) {
        type = "XZ";
        setCoefficients(0, 1, 0, offset);
        n = new double[]{0, 1, 0};
        v = new double[]{1, 0, 0};
        u = new double[]{0, 0, 1};
        setLimits(xLims, null, zLims);
        computeArea();

    }

    public void initializeSurfaceYZ(double[] yLims, double[] zLims, double offset) {
        type = "YZ";
        setCoefficients(1, 0, 0, offset);
        n = new double[]{1, 0, 0};
        v = new double[]{0, 1, 0};
        u = new double[]{0, 0, 1};
        setLimits(null, yLims, zLims);
        computeArea();

    }

    public void computeArea() {
        if (isXY() && xLims != null && yLims != null) {
            area = (xLims[1] - xLims[0]) * (yLims[1] - yLims[0]);
        } else if (isXZ() && xLims != null && zLims != null) {
            area = (xLims[1] - xLims[0]) * (zLims[1] - zLims[0]);
        } else if (isYZ() && yLims != null && zLims != null) {
            area = (yLims[1] - yLims[0]) * (zLims[1] - zLims[0]);
        } else {
            throw new IllegalStateException("Cannot compute area: missing limits or surface not aligned.");
        }
    }

    public boolean isXY() {
        return (A == 0 && B == 0);
    }

    public boolean isXZ() {
        return (A == 0 && C == 0);
    }

    public boolean isYZ() {
        return (B == 0 && C == 0);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getNumberOfTiles() {
        return numberOfTiles;
    }

    public void setNumberOfTiles(int numberOfTiles) {
        this.numberOfTiles = numberOfTiles;
    }

    public double[] getN() {
        return n;
    }

    public void setN(double[] n) {
        this.n = n;
    }

    public double[] getV() {
        return v;
    }

    public void setV(double[] v) {
        this.v = v;
    }

    public double[] getU() {
        return u;
    }

    public void setU(double[] u) {
        this.u = u;
    }

    public double getA() {
        return A;
    }

    public void setA(double A) {
        this.A = A;
    }

    public double getB() {
        return B;
    }

    public void setB(double B) {
        this.B = B;
    }

    public double getC() {
        return C;
    }

    public void setC(double C) {
        this.C = C;
    }

    public double getD() {
        return D;
    }

    public void setD(double D) {
        this.D = D;
    }

    public double[] getXLims() {
        return xLims;
    }

    public void setXLims(double[] xLims) {
        this.xLims = xLims;
    }

    public double[] getYLims() {
        return yLims;
    }

    public void setYLims(double[] yLims) {
        this.yLims = yLims;
    }

    public double[] getZLims() {
        return zLims;
    }

    public void setZLims(double[] zLims) {
        this.zLims = zLims;
    }


}
