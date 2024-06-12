import java.util.*;

public class BinaryTree {
    static class Node {
        int data;
        Node left , right ;
        public Node (int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // create a binary tree from preorder sequence
    static int index = -1;
    public static Node buildTreePreorder(int [] arr) {
        index++;
        // base case
        if(arr[index] == -1 || arr.length == 0) {
            return null;
        }
        // create a current node 
        Node root = new Node(arr[index]);
        // call for its smaller instance
        root.left = buildTreePreorder(arr);
        root.right = buildTreePreorder(arr);
        return root;
    }


    // preorder traversal
    public static void preorderTraversal(Node root) {              // TC : o(n)
        // base case
        if (root == null) {
            return;
        }
        // work
        System.out.print(root.data+" ");
        // call for it's smaller instance
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }


    // inorder traversal
    public static void inorderTraversal(Node root) {              // TC : o(n)
        // base case
        if (root == null) {
            return;
        }
        // call for it's left smaller instance
        inorderTraversal(root.left);
        // work
        System.out.print(root.data+" ");
        // call for it's right smaller instance
        inorderTraversal(root.right);
    }


    // postorder traversal
    public static void postorderTraversal(Node root) {              // TC : o(n)
        // base case
        if (root == null) {
            return;
        }
        // call for it's smaller instance
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        // work
        System.out.print(root.data+" ");
    }



    // levelorder Traversal
    public static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node current = q.remove();
            if (current == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                }else {
                    q.add(null);
                }
            }else {
                System.out.print(current.data+" ");
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
        }

        // Another method

        /* 
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i< size ; i++) {
                Node current = q.remove();
                System.out.print(current.data+" ");
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                } 
            }
            System.out.println();
        }
        */
    }


    // height of a tree
    public static int heigthOfTree(Node root) {
        // base case
        if (root == null) {
            return 0;
        }
        // call for it's smaller instance
        int leftHeight = heigthOfTree(root.left);
        int rightHeight = heigthOfTree(root.right);
        // find the max value between leftsubtree and rightsubtree and add 1 with it as it's current height and return it
        return Math.max(leftHeight , rightHeight) + 1;
    }



    // count no of nodes present in a binary tree
    public static int countNodes (Node root) {
        if (root == null) {
            return 0;
        }
        // call for its smaller instances
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        // return total no of left nodes + right nodes + 1(as current node)
        return leftNodes+rightNodes+1 ; 
    }



    // sum of all nodes value
    public static int sumAllNodesValue (Node root) {
        // base case
        if (root == null) {
            return 0;
        }
        // call for it's smaller instances
        int leftSumValue = sumAllNodesValue(root.left);
        int rightSumValue = sumAllNodesValue(root.right);
        // return  root's left subtree's data + root's left subtree's data + root.data
        return leftSumValue+rightSumValue+root.data;
    }



    // diameter of a tree : No of Nodes in the largest path between 2
    static class Info{      // static class to store all the information of that current node
        int height , diameter;
        public Info (int h , int d) {
            this.height = h;
            this.diameter = d;
        }
    }
    public static Info diameterOfATree(Node root) {
        // base case
        if (root == null) {
            return new Info(0,0);
        }
        // recursive call
        Info leftInfo = diameterOfATree(root.left);
        Info rightInfo = diameterOfATree(root.right);
        // work 
        int diameter = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter),leftInfo.height+rightInfo.height+1);
        int height = Math.max(leftInfo.height , rightInfo.height)+1;
        return new Info(height , diameter);
    }




    // check if a given tree is a subtree of another tree or not
    public static boolean isSubTree (Node root1 , Node root2) {
        // base case
        if (root1 == null) {
            return false;
        }
        if (root1.data == root2.data) {
            if (isidentical(root1 , root2)) {
                return true;
            }
        }
        boolean leftAns = isSubTree(root1.left, root2);
        boolean rightAns = isSubTree(root1.right, root2);

        return leftAns || rightAns;

    }
    public static boolean isidentical (Node root1 , Node root2) {
        // base case
        if  (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.data != root2.data) {
            return false;
        }
        // recursive calls for its left and right subtree
        boolean leftAns = isidentical(root1.left, root2.left);
        boolean righttAns = isidentical(root1.right, root2.right);
        // return 
        if (leftAns && righttAns) {
            return true;
        }
        return false;
    }




    // top view of a binary tree
    static class Information {
        Node node ; 
        int uniqueValue;
        public Information(Node node , int uniqueValue) {
            this.node = node;
            this.uniqueValue = uniqueValue;
        }
    }
    public static void topView (Node root) {
        /***
                       1
                      / \
                     2   3                  // top view = 4 -> 2 -> 1 -> 3 -> 6
                    / \   \
                   4   5   6
        */
        HashMap<Integer , Integer> map = new HashMap<>();
        int max = 0 , min = 0;
        Queue<Information> q = new LinkedList<>();
        q.add(new Information(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i< size ; i++) {
                Information current = q.remove();
                if (!map.containsKey(current.uniqueValue)) {
                    map.put(current.uniqueValue , current.node.data);
                }
                if (current.node.left != null) {
                    q.add(new Information(current.node.left, current.uniqueValue-1));
                    min = Math.min(min  , current.uniqueValue-1);
                }
                if (current.node.right != null) {
                    q.add(new Information(current.node.right, current.uniqueValue+1));
                    max = Math.max(max  , current.uniqueValue+1);
                }
            }
        }
        for (int i = min ; i<= max ; i++) {
            System.out.print(map.get(i)+" ");
        }
    }




    // print Kth level of a tree
    public static void kthLevel (Node root , int k) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0 ; i< size ; i++) {
                Node current = q.remove();
                if (level == k) {
                    System.out.print(current.data+" ");
                }else {
                    if (current.left != null) {
                        q.add(current.left);
                    }
                    if (current.right != null) {
                        q.add(current.right);
                    }
                    
                }
            }
            level++;
        }
    }



    public static void main(String[] args) {
        int arr[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        /***
                       1
                      / \
                     2   3
                    / \   \
                   4   5   6
        */
        Node root = buildTreePreorder(arr);
        // preorderTraversal(root);
        // inorderTraversal(root);
        // postorderTraversal(root);
        levelOrderTraversal(root);
    }
}
