package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllDuplicateSubtrees {
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
	    List<TreeNode> result = new ArrayList<>();
	    Map<String,Integer> map = new HashMap<>();
	        serialize(result,root,map);
	        return result;
	    }
	    
	    private static String serialize(List<TreeNode> res, TreeNode root, Map<String, Integer> map) {
	        
	        if(root == null) return " ";
	        String curr = serialize(res, root.left, map) + " " + serialize(res, root.right, map)+" "+root.val ;
	        
	        int cnt = map.containsKey(curr)?map.get(curr):0;
	       
	        if(cnt == 1) 
	            res.add(root);
	        
	        map.put(curr, cnt + 1);
	        
	        return curr;
	    }
}
