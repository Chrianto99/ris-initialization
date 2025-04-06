package RoomGeometry;

public class Sphere extends Obstacle {
    private double[] center;
    private double radius;

    public Sphere(double[] position, double radius){

        this.center = position;
        this.radius = radius;

    }

    public double[] getCenter() {
        return center;
    }

    public void setCenter(double[] center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

}
