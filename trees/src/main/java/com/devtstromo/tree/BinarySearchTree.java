package com.devtstromo.tree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
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

    private void insert(T data, Node<T> node) {
        if (data.compareTo(node.getData()) < 0) {
            if (node.getLeftChild() == null) {
                node.setLeftChild(new Node<>(data));
            } else {
                insert(data, node.getLeftChild());
            }
        } else if (data.compareTo(node.getData()) > 0) {
            if (node.getRightChild() == null) {
                node.setRightChild(new Node<>(data));
            } else {
                insert(data, node.getRightChild());
            }
        }
    }

    /**
     * Insert alternative
     *
     * <pre>
     *      root = insert(data, root);
     *      return this;
     * </pre>
     *
     * @param data value to be added to the tree
     * @param node first node to traverse
     * @return input node
     */
    private Node<T> insertAlternative(T data, Node<T> node) {
        if (node == null) {
            return new Node<>(data);
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(insertAlternative(data, node.getLeftChild()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(insertAlternative(data, node.getRightChild()));

        }
        return node;
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
        return node;
    }
}
