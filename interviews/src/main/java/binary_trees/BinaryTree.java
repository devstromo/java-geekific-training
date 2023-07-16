package binary_trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BinaryTree {

    int preorderIndex;

    int postorderIndex;
    Map<Integer, Integer> inorderIndexMap = new HashMap<>();
    Map<Integer, Integer> postorderIndexMap = new HashMap<>();

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

    public List<Integer> rightSideView(TreeNode root) {
        var answer = new ArrayList<Integer>();
        if (root == null)
            return answer;
        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var size = queue.size();
            for (int i = 0; i < size; i++) {
                var node = queue.poll();
                if (node.left() != null)
                    queue.add(node.left());
                if (node.right() != null)
                    queue.add(node.right());

                if (i == size - 1)
                    answer.add(node.data());
            }
        }
        return answer;
    }

    public TreeNodeNext connect(TreeNodeNext root) {
        if (root == null)
            return null;
        var queue = new LinkedList<TreeNodeNext>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var size = queue.size();
            for (int i = 0; i < size; i++) {
                var node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                node.next = i == size - 1 ? null : queue.peek();
            }
        }
        return root;
    }

    public TreeNodeNext connectPerfectTree(TreeNodeNext node) {
        if (node == null)
            return null;
        if (node.left != null) {
            node.left.next = node.right;
        }
        if (node.right != null) {
            node.right.next = node.next != null ? node.next.left : null;
        }
        connectPerfectTree(node.left);
        connectPerfectTree(node.right);
        return node;
    }

    public TreeNode arrayToTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        preorderIndex = 0;
        return arrayToTree(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int[] inorder, int left, int right) {
        if (left > right)
            return null;
        var rootValue = preorder[preorderIndex++];
        var leftSubTree = arrayToTree(preorder, inorder, left, inorderIndexMap.get(rootValue) - 1);
        var rightSubTree = arrayToTree(preorder, inorder, inorderIndexMap.get(rootValue) + 1, right);
        return new TreeNode(rootValue, leftSubTree, rightSubTree);
    }

    public TreeNode arrayToTreePostOrder(int[] postorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            postorderIndexMap.put(inorder[i], i);
        }
        preorderIndex = postorder.length - 1;
        return arrayToTreePostOrder(postorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTreePostOrder(int[] postorder, int left, int right) {
        if (left > right)
            return null;
        var rootValue = postorder[postorderIndex--];
        var rightSubTree = arrayToTreePostOrder(postorder, postorderIndexMap.get(rootValue) + 1, right);
        var leftSubTree = arrayToTreePostOrder(postorder, left, postorderIndexMap.get(rootValue) - 1);
        return new TreeNode(rootValue, leftSubTree, rightSubTree);
    }

}
