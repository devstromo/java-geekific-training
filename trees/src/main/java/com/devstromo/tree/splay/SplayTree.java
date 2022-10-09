package com.devstromo.tree.splay;

public class SplayTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public Tree<T> insert(T data) {
        root = insert(root, new Node<>(data));
        return this;
    }

    @Override
    public void delete(T data) {
        root = delete(data, root);
    }

    @Override
    public Node<T> find(T data) {
        Node<T> node = root;
        while (node != null) {
            if (node.getData()
                .compareTo(data) == 0) {
                splay(node);
                return node;
            }
            node = data.compareTo(node.getData()) < 0 ? node.getLeftChild() : node.getRightChild();
        }
        return null;
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
            System.out.println(node.getData());
            traverseInOrder(node.getRightChild());
        }
    }

    private Node<T> delete(T data, Node<T> node) {
        if (node == null)
            return null;
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(delete(data, node.getLeftChild()));
            if (node.getLeftChild() != null) {
                node.getLeftChild()
                    .setParent(node);
            }
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(delete(data, node.getRightChild()));
            if (node.getRightChild() != null) {
                node.getRightChild()
                    .setParent(node);
            }
        } else {
            // One child or leaf node(no children)
            if (node.getLeftChild() == null) {
                return node.getRightChild();
            } else if (node.getRightChild() == null) {
                return node.getLeftChild();
            }
            // Two children
            node.setData(getMax(node.getLeftChild()));
            node.setLeftChild(delete(node.getData(), node.getLeftChild()));
            if (node.getLeftChild() != null) {
                node.getLeftChild()
                    .setParent(node);
            }
        }
        return node;

    }

    public Node<T> find(Node<T> node, T data) {
        if (node != null) {
            if (node.getData()
                .compareTo(data) == 0) {
                splay(node);
                return node;
            }
            Node<T> nextNode = data.compareTo(node.getData()) > 0 ? node.getRightChild() : node.getLeftChild();
            find(nextNode, data);
        }

        return null;
    }

    private void splay(Node<T> node) {
        while (node != root) {
            Node<T> parent = node.getParent();
            if (node.getGrandParent() == null) {
                if (node.isLeftChild()) {
                    rotateRight(parent);
                } else {
                    rotateLeft(parent);
                }
            } else if (node.isLeftChild() && parent.isLeftChild()) {
                rotateRight(parent.getGrandParent());
                rotateRight(parent);
            } else if (node.isRightChild() && parent.isRightChild()) {
                rotateLeft(parent.getGrandParent());
                rotateLeft(parent);
            } else if (node.isLeftChild() && parent.isRightChild()) {
                rotateRight(parent);
                rotateLeft(parent);
            } else {
                rotateLeft(parent);
                rotateRight(parent);
            }
        }
    }

    private void rotateLeft(Node<T> node) {
        Node<T> rightNode = node.getRightChild();
        node.setRightChild(rightNode.getLeftChild());
        if (node.getRightChild() != null) {
            node.getRightChild()
                .setParent(node);
        }
        updateChildrenOfParentNode(node, rightNode);
        rightNode.setLeftChild(node);
        rightNode.setParent(node.getParent());
        node.setParent(rightNode);
    }

    private void rotateRight(Node<T> node) {
        Node<T> leftNode = node.getLeftChild();
        node.setLeftChild(leftNode.getRightChild());
        if (node.getLeftChild() != null) {
            node.getLeftChild()
                .setParent(node);
        }
        updateChildrenOfParentNode(node, leftNode);
        leftNode.setRightChild(node);
        leftNode.setParent(node.getParent());
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


    private Node<T> insert(Node<T> node, Node<T> nodeToInsert) {
        if (node == null) {
            return nodeToInsert;
        }
        if (nodeToInsert.getData().compareTo(node.getData()) < 0) {
            node.setLeftChild(insert(node.getLeftChild(), nodeToInsert));
            node.getLeftChild().setParent(node);
        } else if (nodeToInsert.getData().compareTo(node.getData()) > 0) {
            node.setRightChild(insert(node.getRightChild(), nodeToInsert));
            node.getRightChild().setParent(node);
        }
        return node;
    }

}
