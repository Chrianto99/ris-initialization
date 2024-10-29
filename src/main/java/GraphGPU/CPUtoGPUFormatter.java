package GraphGPU;

import Graph.*;
import java.util.HashMap;
import java.util.Map;

public class CPUtoGPUFormatter {

    Graph g;
    GraphGPU gGPU;



    public CPUtoGPUFormatter(Graph g,GraphGPU gGPU){
        this.g = g;
        this.gGPU = gGPU;

    }

    public void convertDataToGPUFormat(){
        convertDictionariesToLists();

    }

    private void convertDictionariesToLists(){

        gGPU.allEdges.addAll(g.allEdges);
        gGPU.allNodes.addAll(g.allNodes);


    }

}
