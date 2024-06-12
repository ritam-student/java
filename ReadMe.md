# This is my complete Data Structure and Algorithm repository.


# Binary Tree : It is a Hierarchial data structure composed of nodes , where each node has atmost 2 children refffered to as left and right child.
Level and depth starts from 0 and last till leaf node(node that doesn't have any child).

                   1                Level : 1 , depth : 1
                  / \
                 2   3              Level : 2 , depth : 2
                / \   \
               4   5   6            Level : 3 , depth : 3
              / \       \
             7   8       9          Level : 4 , depth : 4
Here leaf nodes are  7,8,5,9 |  children of 4 : 7,8   |   parent of 6 : 3    |   subtree of 2 : left subtree(4,7,8) , right subtree(5)
Ancester of 8 : 4,2,1

<b> Tree traversal : 
<ol type="i">
<li> Preorder Traversal : Print root.data -> go to the left subtree -> right subtree (use recursion)</li>
<li> inorder Traversal :  go to the left subtree -> Print root.data -> right subtree (use recursion)</li>
<li> postorder Traversal :  go to the left subtree -> right subtree -> Print root.data (use recursion)</li>
<li> levelorder Traversal :  go to each level -> add data in queue -> remove data from queue and Print data (traverse iteratively)</li>
</ol>


