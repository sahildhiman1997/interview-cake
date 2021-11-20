public class BinarySearchTreeChecker {

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

    public static boolean isBinarySearchTree(BinaryTreeNode root) {

        // determine if the tree is a valid binary search tree
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return isBinarySearchTree(root, min, max);
    }

    public static boolean isBinarySearchTree(BinaryTreeNode root, int minPossible, int maxPossible) {

        if(root.value>maxPossible || root.value<minPossible){
            return  false;
        }
        Boolean l = true;
        Boolean r = true;
        if(root.left!=null)
                l=isBinarySearchTree(root.left ,Math.min(root.value, minPossible), root.value);
       if(root.right!=null) r= isBinarySearchTree(root.right, root.value , Math.max(maxPossible,root.value));

       if(l==false || r==false){
           return false;
       }
       return  true;

    }


    public static void main(String[] args) {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        final BinaryTreeNode a = root.insertLeft(30);
        a.insertLeft(20);
        a.insertRight(60);
        final BinaryTreeNode b = root.insertRight(80);
        b.insertLeft(70);
        b.insertRight(90);
        final boolean result = isBinarySearchTree(root);
            System.out.println(result);
        }


    }




