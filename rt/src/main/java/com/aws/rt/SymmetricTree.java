package com.aws.rt;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        if (root.left == null &&  root.right == null){
            return true;
        }
        return isTwoTreeSymmetric(root.left, root.right) && root.left.val == root.right.val;
    }

    public boolean isTwoTreeSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }
        if ((left != null && right == null) || (left == null && right != null)){
            return false;
        }
        return isTwoTreeSymmetric(left.left, right.right) && isTwoTreeSymmetric(right.left, left.right) && left.val == right.val;
    }
}
