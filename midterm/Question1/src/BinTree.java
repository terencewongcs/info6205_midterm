
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BinTree<T> {
    public Node<T> root;

    public BinTree() {

    }


    public void populateNextLeft(){
        if(root == null){
            return;
        }

        Queue<Node<T>> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        Node<T> prev = null;

        while(q.size() != 0){
            Node<T> node = q.remove();
            if(node != null){
                if(node.left!= null){
                    q.add(node.left);
                }
                if(node.right!= null){
                    q.add(node.right);
                }
                node.nextLeft = prev;
                prev = node;
            }
            else{
                if(q.size() == 0){
                    break;
                }
                prev = null;
                q.add(null);
            }
        }
        System.out.println();
    }
}