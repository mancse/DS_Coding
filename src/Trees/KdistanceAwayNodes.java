package Trees;

import java.util.ArrayList;
import java.util.List;
/**
 * Given a node and distance k, in binary tree. Find all k distance away nodes around given node in binary tree. 
 * 
 * Idea: Following are the approach to solve this.
 *       a. Write a function printKDistanceDownNodes which can print all nodes k distance down a given node. 
 *       b. Find list of nodes from given node to root of the tree. 
 *          Iterate the above list of nodes and do like following
 *          -For first node in the list... print all nodes k distance down. 
 *          -For second node in the list print all nodes k-1 distance down.
 *          -For third node in the list print all nodes k-2 distance down.
 *          -and so on. 
 *          -Also, while processing ith node in the list keep (i-1)th node as blocker to printKDistanceDownNodes() function. 
 *        
 * @author Manoj.K
 *
 */
public class KdistanceAwayNodes {
	
	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        List<TreeNode> path = new ArrayList<>();
        rootToNodePath(root, target,path);
        TreeNode blocked = null;
        for (int i=path.size() -1; i >= 0; i--){
            TreeNode node = path.get(i);
            List<Integer> list = new ArrayList<>();
            int distFromTarget = path.size() - 1 - i;
            kDistDownNodes(node,k - distFromTarget,list,blocked);
            res.addAll(list);
            blocked = node;
        }
        return res;
    }
    private void kDistDownNodes(TreeNode root, int k,List<Integer> list, TreeNode blocked){
        if (root == null || root == blocked || k < 0){
            return;
        }
        if (k == 0){
            list.add(root.val);
        }
        kDistDownNodes(root.left, k-1, list,blocked);
        kDistDownNodes(root.right, k-1, list,blocked);
    }
    private boolean rootToNodePath(TreeNode root, TreeNode target, List<TreeNode> list){
        if (root == null){
            return false;
        }
        
        //Add the node in the path. 
        list.add(root);

        if (root.val == target.val){
           //If path found return
           return true;
        }
        
        boolean left = rootToNodePath(root.left,target,list);
        boolean right = rootToNodePath(root.right, target, list);
        
        //Return true if path found in left or right recursion
        if (left || right){
            return true;
        } 
        
        //Backtrack if path not found. 
        list.remove(list.size()-1);
        
        return false;
    }
}
