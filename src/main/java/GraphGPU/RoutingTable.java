package GraphGPU;

import java.util.ArrayList;
import java.util.List;

public class RoutingTable {
    public List<InputEdgeBlock> inputEdgeBlocks;


    public RoutingTable(){
        inputEdgeBlocks = new ArrayList<>();

    }

    public void printRoutingTable(){
        for (InputEdgeBlock block : inputEdgeBlocks){
            System.out.println();
            block.printEdgeBlock();
        }
    }
}
