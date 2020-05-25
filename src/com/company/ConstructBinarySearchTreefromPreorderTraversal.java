package com.company;

import java.util.Stack;

public class ConstructBinarySearchTreefromPreorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
    is able to construct a tree but with flaw
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        int count = 1;

        while(count<preorder.length){
            if(preorder[count]<stack.peek().val){
                TreeNode left = new TreeNode(preorder[count]);
                stack.peek().left = left;
                stack.push(left);
                count++;
            }else{
                TreeNode hold = stack.pop();
                while(!stack.isEmpty() && stack.peek().val<preorder[count]){ //keep watching until find a bigger one
                    hold = stack.pop();
                }
                TreeNode right = new TreeNode(preorder[count]);
                hold.right = right;
                stack.push(right);
                count++;
            }
        }
        return root;
    }

//    public TreeNode bstFromPreorder2(int[] preorder) {
//        TreeNode root = new TreeNode(preorder[0]);
//        int count = 1;
//        while(count<preorder.length){
//            if()
//        }
//    }
}
