package Graph;

import Node.Node;

import java.util.List;
import java.util.Random;

public class EdgeManager {

    Graph g;
    int edgeIdx;
    Random rand = new Random();


    public  EdgeManager(Graph g){
        this.g = g;
        edgeIdx = 0;

    }


    public void initializeEdges() {


        double length;
        for (Node start : g.allNodes) {
            for (Node end : g.allNodes) {

                boolean condition1 = start.wall_idx != end.wall_idx;
                boolean condition2 = end.type != "Tx";
                boolean condition3 = start.type != "Rx";
                boolean condition4 = !(start.type.equals("Tx") && end.type.equals("Rx"));
                if (end.type.equals("Rx") && start.type.equals("Tx")) System.out.println(condition4);
                //boolean condition5 = checkIfCouplingPossible(calculateVector(start,end),start.normalVector);
                //boolean condition6 = checkIfCouplingPossible(calculateVector(end,start),start.normalVector);
                if (condition1 && condition2 && condition3 && condition4) {

                    length = calculateDistance(start,end);
                    Edge newEdge = new Edge(start,end,edgeIdx,length);

                    if (start.type.equals("Tx"))
                        newEdge.pathLoss = (g.transmitter.power * g.transmitter.gain) / (Math.pow(4 * Math.PI / g.wavelength,2) * Math.pow(length,g.alpha));
                    else
                        newEdge.pathLoss = g.Gris / (Math.pow(4 * Math.PI / g.wavelength,2) * Math.pow(length,g.alpha));

                    newEdge.blocked = calculateLineOfSightPropability(start,end);
                    g.allEdges.add(newEdge);
                    start.allOutputLinks.add(edgeIdx);
                    end.allInputLinks.add(edgeIdx);
                    edgeIdx++;

                }
            }
        }
    }

    public boolean calculateLineOfSightPropability(Node start,Node end){

        double dA = 2;
        double decayParameter = 50;
        double b = 0.2;

        switch (g.numberOfTiles){
            case 8:
                decayParameter = 100;
                b = rand.nextDouble(0.3) + 0.5;
                break;
            case 16:
                decayParameter = 100;
                b = rand.nextDouble(0.3) + 0.4;
                break;
            case 32:
                decayParameter = 80;
                b = rand.nextDouble(0.5) + 0.2;
                break;
            case 64:
                decayParameter = 80;
                b = rand.nextDouble(0.3) + 0.2;
                break;
        }



        double d = calculateDistance(start,end);
        double pLOS = Math.max(b, Math.min(dA, Math.exp(-d * (d - dA) / decayParameter)));
        pLOS = Math.min(1,pLOS);


        if (d <= dA) pLOS = 1;

        if (g.rand.nextDouble() < pLOS){
            return false;
        }


        return true;
    }

    public static double[] calculateVector(Node start,Node end){

        double Vx = 0,Vy = 0,Vz = 0;
        Vx = end.x - start.x;
        Vy = end.y - start.y;
        Vz = end.z - start.z;

        return new double[] {Vx,Vy,Vz};

    }

    public static boolean checkIfCouplingPossible(double[] V1, double[] V2) {
        // Calculate the dot product
        double dotProduct = V1[0] * V2[0] + V1[1] * V2[1] + V1[2] * V2[2];

        // Calculate the magnitudes of the vectors
        double magnitudeV1 = Math.sqrt(V1[0] * V1[0] + V1[1] * V1[1] + V1[2] * V1[2]);
        double magnitudeV2 = Math.sqrt(V2[0] * V2[0] + V2[1] * V2[1] + V2[2] * V2[2]);

        // Calculate theta (angle between the two vectors)
        double cosTheta = dotProduct / (magnitudeV1 * magnitudeV2);
        double theta = Math.acos(cosTheta); // In radians

        // Calculate phi for each vector
        double phi1 = Math.atan2(V1[1], V1[0]);
        double phi2 = Math.atan2(V2[1], V2[0]);

        // Calculate the difference in phi
        double phiDifference = phi2 - phi1;
        System.out.println(theta);
//        if (phiDifference > phiLimit || (theta > thetaLimit)){
//            return false;
//        }
        return true;
    }

    public static double calculateDistance(Node start,Node end) {

        double dx = Math.pow((end.x - start.x),2);
        double dy = Math.pow((end.y - start.x),2);
        double dz = Math.pow((end.z - start.z),2);
        double distance = Math.sqrt(dx + dy + dz);


        return distance;
    }
}
