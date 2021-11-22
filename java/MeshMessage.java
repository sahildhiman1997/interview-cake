import java.util.*;

public class MeshMessage {
    public static void getPath(Map<String, String[]> graph, String startNode, String endNode) {

        // find the shortest route in the network between the two users
        String[] path = {startNode};
        Deque<String> toVisit = new ArrayDeque<String>();
        toVisit.add(startNode);

        toVisit.remove();

    }

    public static void main(String[] args) {

    }
}
