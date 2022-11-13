public class LinkList {
    public Node head;

    public int length = 0;

    public LinkList() {
        head = null;
    }

    public void insert(Integer data) {
        Node node = head;
        Node newNode = new Node(data);
        if(node==null){
            head=newNode;
        }
        while(node!=null){
            if(node.next!=null&&node.next.data<data){
                node=node.next;
                continue;
            }

            if(data>=node.data){
                newNode.next=node.next;
                node.next=newNode;
                length++;
                return;
            }
            node=node.next;
        }
    }

    public String toString(){
        Node node = head;
        String str="";
        while(node!=null){
            str=str+node.data+",";
            node=node.next;
        }
        return str;
    }
}