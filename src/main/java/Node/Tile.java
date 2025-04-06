package Node;

import java.util.ArrayList;
import java.util.Hashtable;

import Graph.Edge;

public class Tile extends Node {

    private static int NUM_ELEMENTS;
    private static double ELEMENT_SPACING;
    private static double ELEMENT_GAIN;
    private static double MAX_GAIN;
    private static double MAX_DIM;
    private static double WAVELENGTH;

    private transient double[] n, v, u;
    transient private Hashtable<Edge, double[]> thetaPhiArchive;


    public Tile(int id, String type) {
        super(type);
        this.id = id;
        this.type = type;
        thetaPhiArchive = new Hashtable<>();

    }

    public static double getMaxDim() {
        return MAX_DIM;
    }

    public static double getWavelength() {
        return WAVELENGTH;
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

    public Hashtable<Edge, double[]> getThetaPhiArchive() {
        return thetaPhiArchive;
    }

    public double getPhiAngle(Edge edge) {
        return thetaPhiArchive.get(edge)[1];
    }

    public double getThetaAngle(Edge edge) {
        return thetaPhiArchive.get(edge)[0];
    }


}
