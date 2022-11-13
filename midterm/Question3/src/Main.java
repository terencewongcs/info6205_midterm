public class Main {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.root=getBST();
        bst.insideOfRange(5,8);

    }
    private static Node getBST(){
        Node root = new Node(8);
        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        root.left.left.left = new Node(8);
        root.left.right.left = new Node(9);
        root.right.left.right = new Node(10);
        root.right.right.right = new Node(11);



        root.right.right.left = new Node(13);
        root.right.right.left.parent = root.right.right;



        return root;
    }


}