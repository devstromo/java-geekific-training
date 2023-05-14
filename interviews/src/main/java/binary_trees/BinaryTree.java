package binary_trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree {

    public List<List<Integer>> leverOrder(Node root) {
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

    public List<List<Integer>> leverOrder(TreeNode root) {
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

    public List<List<Integer>> leverOrderBottom(TreeNode root) {
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

    public List<List<Integer>> zigZagLeverOrderBottom(TreeNode root) {
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
}
