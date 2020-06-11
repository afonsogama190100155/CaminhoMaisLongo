import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DjikstraPathFinder {
    private Graph graph;
    private char[][] grid;
    private List<Node> openNodes;

    private List<Node> findPathDjikstra(Node startTemp, Node finishTemp) {
        // TODO Auto-generated method stub
        List<Node> nodes = graph.getNodes();
        for (Node node : nodes) {
            node.setDistance(Float.MAX_VALUE);
            openNodes.add(node);
        }
        startTemp.setDistance(0);
        openNodes.add(startTemp);
        while (openNodes.size() > 0) {
            Node currentNode = getLowestDistance(openNodes);
            openNodes.remove(currentNode);

            if (currentNode == finishTemp) {
                finishTemp.setParent(currentNode.getParent());
                return pathNodes(finishTemp);
            }

            for (Node neighbour : graph.getNeighbours(currentNode)) {
                float temp = currentNode.getDistance() + getDistance(currentNode, neighbour);
                if (temp < neighbour.getDistance()) {
                    neighbour.setDistance(temp);
                    neighbour.setParent(currentNode);

                }
            }

        }
        return null;
    }

    private Node getLowestDistance(List<Node> openNodes) {
        Node lowest = openNodes.get(0);
        for (int i = 1; i < openNodes.size(); i++) {
            if (openNodes.get(i).getDistance() < lowest.getDistance()) lowest = openNodes.get(i);
        }
        return lowest;
    }

    private List<Node> pathNodes(Node finish) {
        List<Node> pathNodes = new LinkedList<>();
        Node tempNode = finish;
        while (tempNode.getParent() != null) {
            tempNode = tempNode.getParent();
            pathNodes.add(tempNode);
        }
        return pathNodes;
    }

    public float getDistance(Node node, Node node2) {
        return (float) Math.sqrt((node.getX() - node2.getX()) * (node.getX() - node2.getX())
                + (node.getY() - node2.getY()) * (node.getY() - node2.getY()));
    }

    public char[][] solve(char[][] grid) {
        openNodes = new ArrayList<>();
        graph = new Graph(grid);
        this.grid = grid;
        List<Node> shortest_path = findPathDjikstra(graph.getStart(), graph.getFinish());
        if (shortest_path == null) throw new RuntimeException("Caminho não encontrado");
        return getSolvedGrid(shortest_path);
    }

    private char[][] getSolvedGrid(List<Node> shortest_path) {
        char[][] solved_grid = grid.clone();
        for (Node node : shortest_path) {
            if(node == graph.getFinish() || node == graph.getStart()) continue;
            solved_grid[node.getY()][node.getX()] = 'P';
        }
        return solved_grid;
    }
}
