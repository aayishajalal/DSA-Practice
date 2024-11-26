import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        left = right = null;
    }
}

public class LevelOrderTraversal {
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
    
    //LevelOrderTraversal - level by level
    //Queue (1) - track of nodes - offer(root) --> currNode = poll() --> currNode.left, right push to queue and to subList 
    //MainList (1)  List<List<Integer>>   --- contains level by level subLists
    //subList - for each level & add to mainList TILL queue!=empty
    private List<List<Integer>> levelOrderTraversal(Node root) {
        //queue
        Queue<Node> queue = new LinkedList<>();
        //mainList
        List<List<Integer>> mainList = new LinkedList<>();

        if (root == null)
            return mainList;
        queue.offer(root);
        while (!queue.isEmpty()) {
            //level = queue.size()
            int levelValue = queue.size();
            //create a subList
            List<Integer> subList = new LinkedList<>();

            for (int i = 0; i < levelValue; i++) {
                 //currNode = poll()
                Node currNode = queue.poll();
                subList.add(currNode.value);
                // Enqueue the left and right children if they exist
                if (currNode.left != null)
                    queue.offer(currNode.left);
                if (currNode.right != null)
                    queue.offer(currNode.right);
            }
            
            mainList.add(subList);
        }
        return mainList;
    }

    public static void main(String[] args) {
        LevelOrderTraversal bst = new LevelOrderTraversal();
        //insert()
        bst.insert(40);
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(10);
        bst.insert(80);

        List<List<Integer>> result = bst.levelOrderTraversal(bst.root);
        System.out.println(result);
    }
    
}
