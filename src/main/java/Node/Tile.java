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


    public static int getNumElements() {
        return NUM_ELEMENTS;
    }

    public static void setNumElements(int numElements) {
        NUM_ELEMENTS = numElements;
    }

    public static double getElementSpacing() {
        return ELEMENT_SPACING;
    }

    public static void setElementSpacing(double elementSpacing) {
        ELEMENT_SPACING = elementSpacing;
    }

    public static double getElementGain() {
        return ELEMENT_GAIN;
    }

    public static void setElementGain(double elementGain) {
        ELEMENT_GAIN = elementGain;
    }

    public static double getMaxGain() {
        return MAX_GAIN;
    }

    public static void setMaxGain(double maxGain) {
        MAX_GAIN = maxGain;
    }

    public static double getMaxDim() {
        return MAX_DIM;
    }

    public static void setMaxDim(double maxDim) {
        MAX_DIM = maxDim;
    }

    public static double getWavelength() {
        return WAVELENGTH;
    }

    public static void setWavelength(double wavelength) {
        WAVELENGTH = wavelength;
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

    public void setThetaPhiArchive(Hashtable<Edge, double[]> thetaPhiArchive) {
        this.thetaPhiArchive = thetaPhiArchive;
    }

    public double getPhiAngle(Edge edge) {
        return thetaPhiArchive.get(edge)[1];
    }

    public double getThetaAngle(Edge edge) {
        return thetaPhiArchive.get(edge)[0];
    }


}
