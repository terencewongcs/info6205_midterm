
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
public class BinTree <T> {
    public Node<T> root;

    public BinTree() {

    }

    public void populateParent(){
        populateParent(root);
    }
    private void populateParent(Node<T> node){
        if(node != null){
            if(node.left!=null){
                node.left.parent=node;
            }
            if(node.right!=null){
                node.right.parent=node;
            }
            populateParent(node.left);
            populateParent(node.right);
        }
    }
}