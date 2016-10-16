package lc.easy;

/*
 * problem226:
Invert Binary Tree

 */
public class Problems226 {

	public TreeNode invertTree(TreeNode root) {
		if(root == null)
			return root;
		
		else{
			TreeNode tempTree = null;
			tempTree = root.left;
			root.left = root.right;
			root.right = tempTree;
			
			invertTree(root.left);
			invertTree(root.right);
			
			return root;
		}
	}
	
	public TreeNode invertTree2(TreeNode root) {
		if(root == null)
			return root;
		
		else{
			TreeNode tempTree = null;
			tempTree = root.left;
			root.left = invertTree2(root.right);
			root.right = invertTree2(tempTree);
			
			return root;
		}
	}

	public static void main(String[] args) {

	}

}

// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}