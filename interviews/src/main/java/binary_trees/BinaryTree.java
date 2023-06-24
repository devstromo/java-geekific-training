package binary_trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree {

    public List<List<Integer>> levelOrder(Node root) {
        var result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;
        var queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var currLvlSize = queue.size();
            var level = new ArrayList<Integer>();
            for (int i = 0; i < currLvlSize; i++) {
                var node = queue.poll();
                level.add(node.data());
                queue.addAll(node.children());
            }
            result.add(level);
        }
        return result;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        var result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;
        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var currLvlSize = queue.size();
            var level = new ArrayList<Integer>();
            for (int i = 0; i < currLvlSize; i++) {
                var node = queue.poll();
                if (node.left() != null)
                    queue.add(node.left());
                if (node.right() != null)
                    queue.add(node.left());
            }
            result.add(level);
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        var result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;
        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var currLvlSize = queue.size();
            var level = new ArrayList<Integer>();
            for (int i = 0; i < currLvlSize; i++) {
                var node = queue.poll();
                if (node.left() != null)
                    queue.add(node.left());
                if (node.right() != null)
                    queue.add(node.left());
            }
            result.add(level);
            //            result.add(0, level);
        }
        Collections.reverse(result);
        return result;
    }

    public List<List<Integer>> zigZagLevelOrderBottom(TreeNode root) {
        var result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;
        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        var reverse = false;
        while (!queue.isEmpty()) {
            var currLvlSize = queue.size();
            var level = new ArrayList<Integer>();
            for (int i = 0; i < currLvlSize; i++) {
                var node = queue.poll();
                if (node.left() != null)
                    queue.add(node.left());
                if (node.right() != null)
                    queue.add(node.left());
            }
            if (reverse)
                Collections.reverse(level);
            reverse = !reverse;
            result.add(level);
        }
        return result;
    }

    public boolean isBalancedAtEachLevel(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left()) - height(root.right())) <= 1 && isBalancedAtEachLevel(root.left()) && isBalancedAtEachLevel(root.right());
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left()) - height(root.right())) <= 1;
    }

    public int height(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(height(node.left()), height(node.right())) + 1;
    }

    public int minDepth(TreeNode node) {
        if (node == null)
            return 0;
        var left = minDepth(node.left());
        var right = minDepth(node.right());
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}
