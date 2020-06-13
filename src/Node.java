/**
 * Implementação da interface Node,
 * serve como foundation para o algoritmo
 */
public class Node implements Point {
    private int x, y;
    private Node parent;
    private float distance; 

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
