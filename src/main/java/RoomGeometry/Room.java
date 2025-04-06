package RoomGeometry;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private List<Surface> surfaces;
    private List<Obstacle> obstacles;
    private double[] dims;
    private double totalArea;
    private double alpha;
    private int numReceivers;
    private int numTiles;


    public Room() {
        surfaces = new ArrayList<>();
        obstacles = new ArrayList<>();
        dims = new double[3];


    }

    public void setParameters(int numTiles, int numReceivers, double alpha) {
        this.numTiles = numTiles;
        this.numReceivers = numReceivers;
        this.alpha = alpha;
    }

    public List<Surface> getSurfaces() {
        return surfaces;
    }

    public void setSurfaces(List<Surface> surfaces) {
        this.surfaces = surfaces;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    public double[] getDims() {
        return dims;
    }

    public void setDims(double[] dims) {
        this.dims = dims;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public int getNumReceivers() {
        return numReceivers;
    }

    public void setNumReceivers(int numReceivers) {
        this.numReceivers = numReceivers;
    }

    public int getNumTiles() {
        return numTiles;
    }

    public void setNumTiles(int numTiles) {
        this.numTiles = numTiles;
    }


}
