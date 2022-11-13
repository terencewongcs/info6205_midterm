public class BST  {
    public Node root;
    public BST(){
    }

    public void insideOfRange(int left,int right){
        insideOfRange(root,left,right);
        System.out.println();
    }
    private void insideOfRange(Node node,int left,int right){
        if(node != null){
            if(node.data>=left&&node.data<=right){
                System.out.println(node.data);
            }
            insideOfRange(node.left,left,right);
            insideOfRange(node.right,left,right);
        }
    }
}
