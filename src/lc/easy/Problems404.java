package lc.easy;

import java.util.*;

/*
 * Problems 404:Sum of Left Leaves  
Find the sum of all left leaves in a given binary tree.
 */
public class Problems404 {

	// 方法1: 递归
	public static int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return 0;

		if (root.left != null) {
			if (root.left.left == null && root.left.right == null) // 是左叶子节点
				return root.left.val + sumOfLeftLeaves(root.right);
			else
				return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
		} else
			return sumOfLeftLeaves(root.right);
	}

	// 方法2
	// 利用队列，广度优先遍历
	public static int sumOfLeftLeaves2(TreeNode root) {
		if (root == null)
			return 0;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		int sum = 0;
		TreeNode tmpTree;

		// System.out.println(queue.size());
		while (queue.size() != 0) {
			tmpTree = queue.poll();

			if (tmpTree != null) {
				if (tmpTree.left == null) {
					queue.add(tmpTree.right);
				} else { // tmpTree.left != null
					if (tmpTree.left.left == null && tmpTree.left.right == null) { // 是左叶子节点
						sum += tmpTree.left.val;
						queue.add(tmpTree.right);
					} else { // 不是左叶子节点，是左子树
						queue.add(tmpTree.left);
						queue.add(tmpTree.right);
					}
				}
			}
		}

		return sum;
	}

	// 方法3: 方法2的优化
	public static int sumOfLeftLeaves3(TreeNode root) {
		if (root == null)
			return 0;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		int sum = 0;
		TreeNode tmpTree;

		// System.out.println(queue.size());
		while (queue.size() != 0) {
			tmpTree = queue.poll();

			if (tmpTree.left != null) {
				if (tmpTree.left.left == null && tmpTree.left.right == null) { // 是左叶子节点
					sum += tmpTree.left.val;
				} else { // 不是左叶子节点，是左子树
					queue.add(tmpTree.left);
				}
			}
			if (tmpTree.right != null)
				queue.add(tmpTree.right);
		}
		return sum;
	}

	// 方法4: 方法1的优化
	public static int sumOfLeftLeaves4(TreeNode root) {
		if (root == null)
			return 0;

		if (root.left != null) {
			if (root.left.left == null && root.left.right == null) { // 是左叶子节点
				return root.left.val + sumOfLeftLeaves4(root.right);
			} else {	//不是左叶子节点，是左子树
				return sumOfLeftLeaves4(root.left) + sumOfLeftLeaves4(root.right);
			}
		} else {
			return sumOfLeftLeaves4(root.right);
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode l = new TreeNode(9);
		TreeNode r = new TreeNode(20);
		root.left = l;
		root.right = r;

		TreeNode l1 = new TreeNode(15);
		TreeNode r1 = new TreeNode(7);
		r.left = l1;
		r.right = r1;

		TreeNode l2 = new TreeNode(5);
		TreeNode r2 = new TreeNode(10);
		l.left = l2;
		l.right = r2;

		System.out.println(sumOfLeftLeaves(root));
		System.out.println(sumOfLeftLeaves2(root));
		System.out.println(sumOfLeftLeaves3(root));
		System.out.println(sumOfLeftLeaves4(root));
		/*
		 * Queue<String> q = new LinkedList<String>(); q.add("a"); q.add("b");
		 * q.remove();
		 * 
		 * System.out.println(q.size()); for (String s : q)
		 * System.out.println(s);
		 */
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
