package com.company;

/*
No
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
Return true if and only if the nodes corresponding to the values x and y are cousins.
 */

import java.util.LinkedList;
import java.util.Queue;

/*
go breadth first search, then check if they have the same parent
implement BFS by queue
put them in an array
 */
public class CousinsInBinaryTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) {this.val=val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y){
        if(getDepth(root,x,0)!=getDepth(root,y,0)){
            return false;
        }
        if(sameParents(root,x,y)) return false;

        return true;

    }

    private int getDepth(TreeNode root, int x, int depth){
        if(root==null) return 0;
        if(root.val == x) return depth;

        int level = getDepth(root.left,x, depth+1);
        if(level != 0) return level;

        return getDepth(root.right,x,depth+1);
    }

    private boolean sameParents(TreeNode root, int x, int y){
        if(root==null) return false;

        int l = 0;
        int r = 0;
        if(root.left!=null)  l=root.left.val;
        if(root.right!=null) r=root.right.val;

        //System.out.println("is parent " + (root.left==l && root.right==r) + (root.left==r && root.right==l));

        return (l==x&&r==y) || (l==y&&r==x)
                || sameParents(root.left,x,y) || sameParents(root.right,x,y);
    }

    public boolean isCousins2(TreeNode root, int x, int y) {

        // Queue for BFS
        Queue <TreeNode> queue = new LinkedList <> ();
        queue.add(root);

        while (!queue.isEmpty()) {
            boolean siblings = false;
            boolean cousins = false;

            int nodesAtDepth = queue.size();

            for (int i = 0; i < nodesAtDepth; i++) {
                // FIFO
                TreeNode node = queue.remove();

                // Encountered the marker.
                // Siblings should be set to false as we are crossing the boundary.
                if (node == null) {
                    siblings = false;
                } else {
                    if (node.val == x || node.val == y) {
                        // Set both the siblings and cousins flag to true
                        // for a potential first sibling/cousin found.
                        if (!cousins) {
                            siblings = cousins = true;
                        } else {
                            // If the siblings flag is still true this means we are still
                            // within the siblings boundary and hence the nodes are not cousins.
                            return !siblings;
                        }
                    }

                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                    // Adding the null marker for the siblings
                    queue.add(null);
                }
            }
            // After the end of a level if `cousins` is set to true
            // This means we found only one node at this level
            if (cousins) return false;
        }
        return false;
    }
}
