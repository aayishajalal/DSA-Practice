class Node {
    //Node --> data, next 
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

}


public class LinkedListImplementation {
    private static Node head;

    LinkedListImplementation() {
        head = null;    
    }
    //arrayToLL()
    private Node arrayToLL(int arr[]) {
        //create a node head
        head = new Node(arr[0]);
        //assign temp=head;
        Node temp = head; 
        for (int i = 1; i < arr.length; i++) {
            //create newNode for each element in arr[]
            Node newNode = new Node(arr[i]);
            //point temp.next = newNode;    such at first temp = head ; head.next ==> temp.next == such that its a LL
            temp.next = newNode;
            temp = newNode;
        }
        return head;
    }

    //search()
    private boolean search(Node head, int target) {
        //assign temp = head
        Node temp = head;

        while (temp != null) {
            //if(temp.data == target)
            if (temp.data == target) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    //lengthOfLL()
    private int lengthOfLL(Node head) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    private void display(Node head) {
        Node temp = head;
        if (head == null)
            System.out.println("No LL present");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    //insert()--> Beg, end, pos, before, after

    private void insertBeg(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    private void insertEnd(int data) {
        Node newNode = new Node(data);
        Node temp = head;
        if (head == null) {
            insertBeg(data);
            return;
        }
            
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    private void insertPosition(int position, int data) {
        Node newNode = new Node(data);
        int curPos = 0;
        Node temp = head;
        if (head == null) {
            head = newNode;
            return;
        }
        while (curPos - 1 != position && temp != null) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position not found returned");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    private void insertBefore(int data, int target) {
        //head==null --> insertBeg()
        if (head == null) {
            insertBeg(data);
            return;
        }
        Node temp = head;
        //traverse till we reach temp.next.data == target
        while (temp.next != null && temp.next.data != target) {
            temp = temp.next;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    private void insertAfter(int data, int target) {
        if (head == null) {
            insertBeg(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        while (temp != null && temp.data != target) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Target not found");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
   
    //delete()--> beg, end, pos, before, after 
    private void deleteBeg() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete");
            return;
        }
        head = head.next;
    }

    private void deleteEnd() {
        Node temp = head;
        if (head == null) {
            System.out.println("List is empty. Nothing to delete");
            return;
        }
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }
   
    private void deletePosition(int position) {
        int curPos = 0;
        Node temp = head;
        if (head == null) {
            return;
        }
        while (temp.next != null && curPos != position - 1) {
            temp = temp.next;
            curPos++;
        }
        temp.next = temp.next.next;
    }
    
    private void deleteBefore(int target) {
        Node temp = head;
        Node prev = null;

        while (temp.next.data != target && temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Target Not Found");
            return;
        }
        if (prev == null) {
            deleteBeg();
        }else{
            prev.next = temp.next;}
    }
    
    private void deleteAfter(int target) {
        Node temp = head;
        if (head == null) {
            System.out.println("Empty LinkedList");
            return;
        }
        while (temp != null && temp.data != target) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("No node exists after " + target + ".");
            return;
        }
        temp.next = temp.next.next;
    }
    public static void main(String[] args) {
        LinkedListImplementation list = new LinkedListImplementation();
        int arr[] = { 1, 2, 3 };
        head = list.arrayToLL(arr);
        Node temp = head;
        System.out.println("Elements in LL: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
        int data = 5, target = 3;
        System.out.println("Search Element"+ target+"Found: "+list.search(head,target));
        int length = list.lengthOfLL(head);
        System.out.print("Length of LL: " + length );
        list.insertBeg(data);
        System.out.println("Insert At Beginning: ");
        list.display(head);
        list.insertEnd(data);
        System.out.println("Insert At End: "+data);
        list.display(head);
        list.insertBefore(data,target);
        System.out.println("Insert Before: " + data);
        list.display(head);
        list.insertAfter(data,target);
        System.out.println("Insert After: " + data);
        list.display(head);
        int position = 2;
        list.insertPosition(position, data);
        System.out.println("Insert At Position: "+position+" data: "+data);
        list.display(head);
        
        list.deleteBeg();
        System.out.println("Delete at Begining: ");
        list.display(head);
        list.deleteEnd();
        System.out.println("Delete at End: ");
        list.display(head);
        list.deletePosition(position);
        System.out.println("Delete at Position: "+position);
        list.display(head);
        
        list.deleteBefore(target);
        System.out.println("Delete Before: "+target);
        list.display(head);
        list.deleteAfter(target);
        System.out.println("Delete After: "+target);
        list.display(head);
    }
}

