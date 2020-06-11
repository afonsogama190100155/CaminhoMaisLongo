public class Node extends Point{
    private Node parent;
    private float distance;

    public Node(int x,int y){
        super(x,y);
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
}
