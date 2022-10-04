package com.devstromo.tree;

import static java.lang.Math.max;

import java.util.List;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public Tree<T> insert(T data) {
        if (isEmpty()) {
            root = new Node<>(data);
        } else {
            insert(data, root);
        }
        return this;
    }

    @Override
    public void delete(T data) {
        root = delete(data, root);
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

    @Override
    public List<T> getSortedElements() {
        return null;
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

    private Node<T> insert(T data, Node<T> node) {
        if (node == null) {
            return new Node<>(data);
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(insert(data, node.getLeftChild()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(insert(data, node.getRightChild()));
        } else {
            return node;
        }
        updateHeight(node);
        return applyRotation(node);
    }

    private Node<T> delete(T data, Node<T> node) {
        if (node == null) {
            return null;
        }

        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(delete(data, node.getRightChild()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(delete(data, node.getRightChild()));
        } else {
            // One child or leaf node(no children)
            if (node.getLeftChild() == null) {
                return node.getRightChild();
            } else if (node.getRightChild() == null) {
                return node.getLeftChild();
            }
            //Two children
            node.setData(getMax(node.getLeftChild()));// predecessor
            node.setLeftChild(delete(node.getData(), node.getLeftChild()));

        }
        updateHeight(node);
        return applyRotation(node);
    }

    private void updateHeight(Node<T> node) {
        int maxHeight = max(height(node.getLeftChild()), height(node.getRightChild()));
        node.setHeight(maxHeight + 1);
    }

    private Node<T> applyRotation(Node<T> node) {
        int balance = balance(node);
        if (balance > 1) {
            // left-heavy
            if (balance(node.getLeftChild()) < 0) {
                node.setLeftChild(rotateLeft(node.getLeftChild()));
            }
            return rotateRight(node);
        }
        if (balance < -1) {
            // right-heavy
            if (balance(node.getRightChild()) > 0) {
                node.setRightChild(rotateRight(node.getRightChild()));
            }
            return rotateLeft(node);
        }

        return null;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> leftNode = node.getLeftChild();
        Node<T> centerNode = leftNode.getRightChild();
        leftNode.setRightChild(node);
        node.setLeftChild(centerNode);
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> rightNode = node.getRightChild();
        Node<T> centerNode = rightNode.getLeftChild();
        rightNode.setLeftChild(node);
        node.setRightChild(centerNode);
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    private int balance(Node<T> node) {
        return node != null ? height(node.getLeftChild()) - height(node.getRightChild()) : 0;
    }

    private int height(Node<T> node) {
        return node != null ? node.getHeight() : 0;
    }
}
