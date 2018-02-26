package mdza.cs.graphs.tree;

import java.util.Comparator;
import mdza.cs.graphs.Node;
/**
 *
 * @author Alberto Mendoza>
 */
public class BST<T extends Comparable> {
    private BSTNode root;
    
    public BST() { }
    
    public boolean add(T data) {
        BSTNode current = root;
        BSTNode newNode = new BSTNode(data);
        if (root == null) {
            root = new BSTNode(data);
            return true;
        }
        
        while(current != null) {
            if (isLessThan(current, newNode)) {
                if(current.left == null) {
                    current.left = newNode;
                    return true;
                }
                else
                    current = current.left;
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    return true;
                }
                else
                    current = current.right;
            }
        }
        return false;
    }
    
    public void remove(T data) {
        remove(root, data);
    }
    
    private BSTNode remove(BSTNode node, T data) {
        BSTNode prev = node;
        if (node == null || 
                (node == root && node.left == null && node.right == null)) {
            root = null;
            return null;
        }
        
        if (node.data.equals(data)) {
            if (!hasChildren(node)) 
                return null;
            
            if (hasChildren(node)) {
                T succesor = getInorderSuccesor(node);
                remove(succesor);
                node.data = succesor;
                return node;   // was null before
            } else if (hasLeftChild(node)) {
                return node.left;
            } else
                return node.right;
           
        } else if(isLessThan((T)node.data, data)) {
            BSTNode newNode = remove(node.left, data);
            prev.left = newNode;
            
        } else {
            BSTNode newNode = remove(node.right, data);
            prev.right = newNode;
        }
        return prev; // no delete operation
    }
    
    public boolean remove_internal(T data) {
        BSTNode prev = root;
        BSTNode current = root;
        
        while (!current.data.equals(data) && current != null) {
            if (isLessThan((T) current.data, data)) {
                prev = current;
                current = current.left;
            } else {
                prev = current;
                current = current.right;
            }
        }
        
        if (current == null) return false;
        
        // Is a leaf  just delete
        if (!hasChildren(current)) {
            prev.left = null;
            prev.right = null;
            return true;
        } 
        // Has two children  copy inorder successor to the node and delete inorder successor
        else if(hasChildren(current)) {
            T succesor = getInorderSuccesor(current);
            current.data = succesor;
            remove_internal(succesor);
            return true;
        }
        // Has only one child  copy the child to the node and delete the child
        else if (hasLeftChild(current)) {
            prev.left = current.left;
            return true;
        }
        
        else if (hasRightChild(current)) {
            prev.right = current.right;
            return true;
        }
        
        return false;  
    }

    
    public void inOrder() { 
        inOrder(root);
        System.out.println();
    }
    
    private void inOrder(BSTNode node) {
        if (node ==  null) return;
        inOrder(node.left);
        System.out.print(node.getData() + " ");
        inOrder(node.right);
    }
    
    private T getInorderSuccesor(BSTNode node) {
        BSTNode current = node;
        current = current.right;

        
        while(current != null && current.left != null) {
            current = current.left;
        }
        return (T) current.data;
    }
    
    private boolean hasChildren(BSTNode node) { 
        return hasLeftChild(node) || hasRightChild(node);  // was AND
    }
    
    private boolean hasLeftChild(BSTNode node) { return node.left != null; }
    
    private boolean hasRightChild(BSTNode node) { return node.right != null; }
    
    public boolean contains(T data) {
        BSTNode current = root;
        BSTNode newNode = new BSTNode(data);
        
        while(current != null) {
            if(isLessThan(current, newNode)) 
                current = current.left;
            else
                current = current.right;
            
            if (current.getData().equals(data))
                return true;
        }
        
        return false;      
    }
    
    private boolean isLessThan(BSTNode a, BSTNode b) {
        return (a.getData().compareTo(b.getData()) > 0);
    }
    
   private boolean isLessThan(T a, T b) {
        return (a.compareTo(b) > 0);
    }
    
    public static class BSTNode<T extends Comparable>{
        BSTNode() {}
        BSTNode(T data) { this.data = data; }
        
        public T getData() { return data; }
        public void setLeft(BSTNode node)  { left = node; }
        public void setRight(BSTNode node) { right = node; }
        
        private T data;
        private BSTNode left;
        private BSTNode right;

    }
    
    public static void Tester() {
        BST bst = new BST();
        bst.add(10);
        bst.add(7);
        bst.add(12);
        bst.add(11);
        bst.add(15);
        bst.add(14);
        bst.inOrder();
        
        bst.remove(14);
        bst.inOrder();
        
        bst.remove(12);
        bst.inOrder();
        
        bst.remove(7);
        bst.inOrder();
        
        bst.remove(10);
        bst.inOrder();
    }
}
