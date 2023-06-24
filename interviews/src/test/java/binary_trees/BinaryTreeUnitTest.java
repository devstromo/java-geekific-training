package binary_trees;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryTreeUnitTest {
    private BinaryTree binaryTree;
    private TreeNode root;
    private TreeNode node1;
    private TreeNode node2;
    private TreeNode node3;
    private TreeNode node4;
    private TreeNode node5;

    @BeforeEach
    public void setUp() {
        binaryTree = new BinaryTree();

        // Setting up a binary tree for testing.
        node1 = new TreeNode(1, null, null);
        node2 = new TreeNode(2, null, null);
        node3 = new TreeNode(3, node1, node2);
        node4 = new TreeNode(4, null, null);
        node5 = new TreeNode(5, node3, node4);
        root = node5;
    }

    @Test
    public void testIsBalancedAtEachLevel() {
        assertTrue(binaryTree.isBalancedAtEachLevel(root));
        assertTrue(binaryTree.isBalancedAtEachLevel(node3));

        TreeNode unbalancedNode = new TreeNode(6, node5, null);
        assertFalse(binaryTree.isBalancedAtEachLevel(unbalancedNode));
    }

    @Test
    public void testIsBalanced() {
        assertTrue(binaryTree.isBalanced(root));
        assertTrue(binaryTree.isBalanced(node3));

        TreeNode unbalancedNode = new TreeNode(6, node5, null);
        assertFalse(binaryTree.isBalanced(unbalancedNode));
    }

    @Test
    public void testHeight() {
        assertEquals(3, binaryTree.height(root));
        assertEquals(2, binaryTree.height(node3));
        assertEquals(1, binaryTree.height(node1));
    }

    @Test
    public void testMinDepth() {
        assertEquals(2, binaryTree.minDepth(root));
        assertEquals(1, binaryTree.minDepth(node1));
    }
}