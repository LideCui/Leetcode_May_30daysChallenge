package com.company;

import java.util.ArrayList;
import java.util.Stack;

/*
Find kth element of a binary tree
best time complexity O(logN)
 */
public class KthSmallestElementInABST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        System.out.println(new KthSmallestElementInABST().kthSmallest(root,4));
    }

    public static class TreeNode {
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


    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode ptr = root;
        int result = 0;
        while(!st.isEmpty() || ptr!=null){
            if(ptr!=null){
                st.push(ptr);
                ptr= ptr.left;
            }else{
                TreeNode t = st.pop();
                k--;
                if(k==0) result = t.val;
                ptr = t.right;
            }
        }
        return result;
    }

    public int kthSmallest2(TreeNode root, int k) {

        Stack<TreeNode> stack =new Stack<>();
        TreeNode node = root;
        int i=0;

        while(node!=null || !stack.isEmpty())
        {
            while(node!=null)
            {
                stack.add(node);
                node= node.left;
            }

            node= stack.pop();
            i++;

            if(i>=k)
                return node.val;

            node=node.right;

        }
        return -1;
    }


}
