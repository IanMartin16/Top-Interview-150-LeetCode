import java.util.Stack;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAllLeft(root);
    }

    // This function returns true if there is a next smallest number.
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // This function returns the next smallest number.
    public int next() {
        TreeNode currentNode = stack.pop();
        int result = currentNode.val;
        if (currentNode.right != null) {
            pushAllLeft(currentNode.right);
        }
        return result;
    }

    // Helper function to push all the left nodes of the given subtree into the stack.
    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    // A simple main method to demonstrate the usage of the BSTIterator class.
    public static void main(String[] args) {
        // Create a sample BST:
        //        7
        //       / \
        //      3   15
        //         /  \
        //        9    20

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        // Create the BSTIterator object.
        BSTIterator iterator = new BSTIterator(root);

        // Iterate over the BST using the iterator.
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // Expected output: 3, 7, 9, 15, 20
    }
}


//Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

//BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. 
//The root of the BST is given as part of the constructor. 
//The pointer should be initialized to a non-existent number smaller than any element in the BST.
//boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
//int next() Moves the pointer to the right, then returns the number at the pointer.
//Notice that by initializing the pointer to a non-existent smallest number, 
//the first call to next() will return the smallest element in the BST.

//You may assume that next() calls will always be valid. That is, 
//there will be at least a next number in the in-order traversal when next() is called.