import java.util.ArrayList;
import java.util.List;

/**
 * Estrutura de dados contendo o grafo
 * em forma de uma lista de adjacencia(parecido com a matriz de adjacencia
 * mas ocupa menos espaço)
 */
public class Graph {
    private final int size; //Tamanho da grid
    private List<List<Node>> adjacencyList; //Estrutura de dados
    private Node start; //Node inicial
    private Node finish; //Node final

    public Graph(char[][] grid) { 
        adjacencyList = new ArrayList<>();
        size = grid.length;
        addNodesToAdjacencyList(grid);
        addNeighboursToAdjacencyList(grid);

    }

    /**
     * Adiciona a  lista de adjacencia os vizinhos de cada Node
     * @param grid char grid
     */
    private void addNeighboursToAdjacencyList(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                List<Node> selected_node_list = getNodeList(j, i);
                List<Point> neighbours = getNeighbours(j, i);
                for (Point point : neighbours) {
                    selected_node_list.add(getNode(point.getX(), point.getY()));
                }
            }
        }
    }


    /**
     * Adiciona a lista de adjacencia as nodes
     * @param grid char grid
     */
    private void addNodesToAdjacencyList(char[][] grid) {
        int num_starts = 0;
        int num_finishes = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i].length != grid.length) throw new IllegalArgumentException("Grelha invalida, tem de ser quadrada");
                Node selected_node;
                if (grid[i][j] == 'S') {
                    start = new Node(j, i);
                    selected_node = start;
                    num_starts++;
                } else if (grid[i][j] == 'F') {
                    finish = new Node(j, i);
                    selected_node = finish;
                    num_finishes++;
                } else selected_node = new Node(j, i);
                List<Node> list = new ArrayList<>();
                list.add(selected_node);
                adjacencyList.add(list);
            }
        }
        if (num_starts != 1) throw new IllegalArgumentException("Grelha invalida, tem de ter um inicio");
        if (num_finishes != 1) throw new IllegalArgumentException("Grelha invalida, tem de ter um fim");
    }

    /**
     * @return nodes da lista de adjacencia
     */
    public List<Node> getNodes() {
        List<Node> nodes = new ArrayList<>();
        for (List<Node> list : adjacencyList) {
            nodes.add(list.get(0));
        }
        return nodes;
    }

    /**
     * Produz uma lista de vizinhos de um certo ponto em forma de lista de Points
     * @param x coordenada x
     * @param y coordenada y
     */
    private List<Point> getNeighbours(int x, int y) {
        List<Point> neighbours = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (j == 0 && i == 0)
                    continue;

                int neighbourX = x + i;
                int neighbourY = y + j;

                if (isValid(new Node(neighbourX, neighbourY)))
                    neighbours.add(new Node(neighbourX, neighbourY));
            }
        }
        return neighbours;
    }

    /**
     * Produz uma lista de vizinhos de um certo node em forma de lista de nodes
     * @param node Node
     * @return lista de nodes
     */
    public List<Node> getNeighbours(Node node) {
        List<Node> neighbours = new ArrayList<>();
        for (List<Node> list : adjacencyList) {
            Node selected_node = list.get(0);
            if (selected_node == node) {
                for (int i = 1; i < list.size(); i++) {
                    neighbours.add(list.get(i));
                }
                return neighbours;
            }
        }
        return null;
    }

    /**
     * Verifica se Node é valido (esta dentro da grid)
     */
    public boolean isValid(Node node) { 
        return node.getX() >= 0 && node.getX() < size && node.getY() >= 0 && node.getY() < size;
    }

    /**
     * Retorna a node na posição x e y
     */
    private Node getNode(int x, int y) {
        int index = y * size + x;
        return adjacencyList.get(index).get(0);
    }

    /**
     * Retorna a node e os seus vizinhos na posição x e  y
     */
    private List<Node> getNodeList(int x, int y) {
        int index = y*size+x;
        return adjacencyList.get(index);
    }

    public Node getStart() {
        return start;
    }

    public Node getFinish() {
        return finish;
    }

}
