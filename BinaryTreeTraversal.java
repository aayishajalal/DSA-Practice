//Binary Tree - Node class, insert(), search(), traversal(), main()
//BST 
class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        left = right = null;
    }
}

//Main class 
public class BinaryTreeTraversal {
    //1.define a root Node
    Node root;

    //2.insert() --- to get values and assign to insertNode(Node root, int value);
    //if not we need to pass from main() -->  bst.root = bst.insertNode(bst.root, value);
    public void insert(int value) {
        root = insertNode(root, value);
    }

    private  Node insertNode(Node root, int value) {
        //root==null --> new node 
        if (root == null)
            return new Node(value);
        //BST
        //value<root --> add to left subTree 
        // else add to right subTree
        if (value < root.value)
            root.left = insertNode(root.left, value);
        else if (value > root.value)
            root.right = insertNode(root.right, value);
        return root;
    }
    
    //3.traversal()
    public void traversal(String traversalType) {
            switch (traversalType) {
                case "inorder" -> inorderTraversal(root);
                case "preorder" -> preorderTraversal(root);
                case "postorder" -> postorderTraversal(root);
                default-> System.out.println("Not a valid input");
            }
    }
    
    //inorder - Left Root Right
    private  void inorderTraversal(Node root) {
        //no return - as traversal happens within the tree 
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.value + " ");
            inorderTraversal(root.right);
        }

    }
    //preorder
    private  void preorderTraversal(Node root) {
        //no return - as traversal happens within the tree 
        if (root != null) {
            System.out.print(root.value + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }

    }
    
     //postorder
     private  void postorderTraversal(Node root) {
         //no return - as traversal happens within the tree 
         if (root != null) {
             postorderTraversal(root.left);
             postorderTraversal(root.right);
             System.out.print(root.value + " ");
         }

     }
    
     //4.search-- to avoid passing from main() as bst.search(bst.root, 40)
     //we could pass now as bst.search(40);
     public boolean search(int value) {
         return searchNode(root, value);
     }
     //compares root and searches the node
     private boolean searchNode(Node root, int value) {
         if (root == null)
             return false;
         //value same as root -- true
         if (root.value == value)
             return true;

         //search in left --> value<root.value 
         //search in right --> value>root.value  
         return value < root.value ? searchNode(root.left, value) : searchNode(root.right, value);
     }
     //5.main()
     public static void main(String[] args) {
        BinaryTreeTraversal bst = new BinaryTreeTraversal();
        //insert()
        bst.insert(40);
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(10);
        bst.insert(80);
        //root value
        System.out.println("Root: "+bst.root.value);
        //traversal()
        System.out.println("Inorder traversal:");
        bst.traversal("inorder");
        System.out.println();

        System.out.println("Preorder traversal:");
        bst.traversal("preorder");
        System.out.println();

        System.out.println("Postorder traversal:");
        bst.traversal("postorder");
        System.out.println();

        //search()
        int searchValue = 100;
        System.out.println("bst search value:"+searchValue+bst.search(searchValue));
        
    }
}