package safenet;

/**
 * Created by twer on 15-4-29.
 */
public class ReverselinkedList {
    class Node{
        public String Item;
        public Node Next;
        public Node(String item){
            Item=item;
        }
    }
    public static void main(String[] args){
        ReverselinkedList instance = new ReverselinkedList();
        Node head=instance.BuildNodeList(10);
        Node newHead=instance.ReverseList(head);
        instance.PrintLinkedList(newHead);
    }

    private Node ReverseList(Node head) {
        Node firstPointer=head;
        Node secondPoinder=head.Next;
        Node thirdPointer=head.Next.Next;
        firstPointer.Next=null;
        while(thirdPointer!=null)
        {
            secondPoinder.Next=firstPointer;
            firstPointer=secondPoinder;
            secondPoinder=thirdPointer;
            thirdPointer=thirdPointer.Next;
        }
        secondPoinder.Next=firstPointer;
        return secondPoinder;
    }

    private void PrintLinkedList(Node head) {
        while(head!=null){
            System.out.println(head.Item);
            head=head.Next;
        }
    }

    private Node BuildNodeList(int number) {
        int i=0;
        Node head=new Node("head");
        Node current=head;
        while(i<number){
            Node next=new Node("next"+i);
            current.Next=next;
            current=next;
            i++;
        }
        return head;
    }
}
