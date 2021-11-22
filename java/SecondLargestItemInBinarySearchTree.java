public class SecondLargestItemInBinarySearchTree {
    public static class BinaryTreeNode {

        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }
    }

    public static int findSecondLargest(BinaryTreeNode rootNode) {
        if (rootNode.left == null && rootNode.right == null)
            throw new IllegalArgumentException("Atleast two values are required ");

        //let's get the parent of the max value..
        if (rootNode.right != null) {
            while (rootNode.right.right != null) {
                rootNode = rootNode.right;
            }
        }

//      where the root node doesn't have any right child, rootnode itself is largest,
//      hence second largest will be found in left () -> child
//      since we already checked if it has no childs throw exception we need not check again
        if (rootNode.right == null) {
            return findMax(rootNode.left);
        }

        else{
            if(rootNode.right.left!=null){
            return  findMax(rootNode.right.left);}

            return rootNode.value;

        }
    }

    private static int findMax(BinaryTreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.value;
    }


    public static void main(String[] args) {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        root.insertRight(60).insertRight(70).insertRight(80);
        final int actual = findSecondLargest(root);
        System.out.println(actual);
    }
}
