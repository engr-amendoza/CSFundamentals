package mdza.cs.graphs;

import java.util.ArrayList;
import java.util.List;

public class Node <T extends Comparable> {
    
    public Node() {}
    public Node(T data) { 
        this.data = data; 
        children = new ArrayList<>();
    }
    
    public T getData() { return data; }
    public List<Node> getChildren() { return children; }   
    public void setData(T data) { this.data = data; }
    public void addChild(Node node) { children.add(node); }
    public void removeChild(Node node) { children.remove(node); }
    public boolean hasChild(Node node) { return children.contains(node); }
    public boolean hasChild(T data) { return children.contains(new Node(data)); }
    
    protected List<Node> children;
    protected T data;
    
    public static void Tester() {
        Node a = new Node(5);
        Node b = new Node(2);
        Node c = new Node(7);
        Node d = new Node(9);
        Node e = new Node(4);
        
        Node root = a;
        
        e.addChild(b);
        e.addChild(c);
        
        c.addChild(d);
        c.addChild(a);
        
        d.addChild(b);
        
        
    }
}
