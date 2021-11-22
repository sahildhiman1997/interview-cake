import java.util.HashSet;

public class BalancedBinaryTree {
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

    public static boolean isBalanced(BinaryTreeNode treeRoot) {


        int depth = -1;
        HashSet<Integer> depths = new HashSet();
        // determine if the tree is superbalanced
        return isBalanced(treeRoot, depth, depths);

    }

    private static boolean isBalanced(BinaryTreeNode treeRoot, int depth, HashSet<Integer> depths) {
        depth += 1;
        if (treeRoot.left == null && treeRoot.right == null) {
            for (int d : depths) {
                if ((depth - d) >= 2) {
                    return false;
                }
            }
            depths.add(depth);
            if (depths.size() > 2) {
                return false;
            }
            return true;

        }
        Boolean l = true;
        Boolean r = true;
        if (treeRoot.left != null) {
            l = isBalanced(treeRoot.left, depth, depths);
        }
        if (l == false) {
            return false;
        }
        if (treeRoot.right != null) {
            r = isBalanced(treeRoot.right, depth, depths);
        }
        if (r == false) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        final BinaryTreeNode root = new BinaryTreeNode(6);
        root.insertLeft(1);
        root.insertRight(100).insertRight(1);
        final boolean result = isBalanced(root);
        System.out.println(result);
    }
}
