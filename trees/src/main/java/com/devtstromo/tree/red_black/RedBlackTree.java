package com.devtstromo.tree.red_black;

import static java.awt.Color.BLACK;
import static java.awt.Color.RED;

import com.devtstromo.tree.Tree;

public class RedBlackTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public Tree<T> insert(T data) {
        Node<T> node = new Node<>(data);
        root = insert(root, node);
        recolorAndRotate(node);
        return this;
    }

    @Override
    public void delete(T data) {

    }

    @Override
    public void traverse() {
        traverseInOrder(root);
    }

    @Override
    public T getMax() {
        if (isEmpty()) {
            return null;
        }
        return getMax(root);
    }

    @Override
    public T getMin() {
        if (isEmpty()) {
            return null;
        }
        return getMin(root);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    private T getMin(Node<T> node) {
        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        }
        return node.getData();
    }

    private T getMax(Node<T> node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }
        return node.getData();
    }

    private void traverseInOrder(Node<T> node) {
        if (node != null) {
            traverseInOrder(node.getLeftChild());
            System.out.println(node);
            traverseInOrder(node.getRightChild());
        }
    }

    private Node<T> insert(Node<T> node, Node<T> nodeToInsert) {
        if (node == null) {
            return nodeToInsert;
        }
        if (nodeToInsert.getData()
            .compareTo(node.getData()) < 0) {
            node.setLeftChild(insert(node.getLeftChild(), nodeToInsert));
            node.getLeftChild()
                .setParent(node);
        } else if (nodeToInsert.getData()
            .compareTo(node.getData()) > 0) {
            node.setRightChild(insert(node.getRightChild(), nodeToInsert));
            node.getRightChild()
                .setParent(node);
        }
        return node;
    }

    private void recolorAndRotate(Node<T> node) {
        Node<T> parent = node.getParent();
        if (node != root && parent.getColor() == RED) {
            Node<T> grandParent = node.getParent()
                .getParent();
            Node<T> uncle = parent.isLeftChild() ? grandParent.getRightChild() : grandParent.getLeftChild();
            if (uncle != null && uncle.getColor() == RED) {
                // recoloring
                handleRecoloring(parent, uncle, grandParent);
            } else if (parent.isLeftChild()) {
                // left-heavy or left-right
                handleLeftSituations(node, parent, grandParent);
            } else if (!parent.isLeftChild()) {
                // right-heavy or right left
                handleRightSituations(node, parent, grandParent);
            }
        }
        root.setColor(BLACK);
    }

    private void handleRecoloring(Node<T> parent, Node<T> uncle, Node<T> grandParent) {
        uncle.flipColor();
        parent.flipColor();
        grandParent.flipColor();
        recolorAndRotate(grandParent);
    }

    private void handleLeftSituations(Node<T> node, Node<T> parent, Node<T> grandParent) {
        if (!node.isLeftChild()) {
            rotateLeft(parent);
        }
        parent.flipColor();
        grandParent.flipColor();
        rotateRight(grandParent);
        recolorAndRotate(node.isLeftChild() ? parent : grandParent);
    }

    private void handleRightSituations(Node<T> node, Node<T> parent, Node<T> grandParent) {
        if (node.isLeftChild()) {
            rotateRight(grandParent);
        }
        parent.flipColor();
        grandParent.flipColor();
        rotateLeft(parent);
        recolorAndRotate(node.isLeftChild() ? grandParent : parent);
    }

    private void rotateLeft(Node<T> node) {
        Node<T> rightNode = node.getRightChild();
        node.setRightChild(rightNode.getLeftChild());
        if (node.getRightChild() != null) {
            node.getRightChild()
                .setParent(node);
        }
        rightNode.setLeftChild(node);
        rightNode.setParent(node.getParent());
        updateChildrenOfParentNode(node, rightNode);
        node.setParent(rightNode);
    }

    private void rotateRight(Node<T> node) {
        Node<T> leftNode = node.getLeftChild();
        node.setLeftChild(leftNode.getRightChild());
        if (node.getLeftChild() != null) {
            node.getLeftChild()
                .setParent(node);
        }
        leftNode.setRightChild(node);
        leftNode.setParent(node.getParent());
        updateChildrenOfParentNode(node, leftNode);
        node.setParent(leftNode);
    }

    private void updateChildrenOfParentNode(Node<T> node, Node<T> tempNode) {
        if (node.getParent() == null) {
            root = tempNode;
        } else if (node.isLeftChild()) {
            node.getParent()
                .setLeftChild(tempNode);
        } else {
            node.getParent()
                .setRightChild(tempNode);
        }
    }
}
