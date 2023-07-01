package com.devstromo.list.doublelinked;

public class DoublyLinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;

    @Override
    public void insertAtHead(T data) {
        var node = new Node<T>(data);
        if (isEmpty())
            head = tail = node;
        else {
            node.setNext(head);
            head = node;
        }
    }

    @Override
    public void insertAtTail(T data) {
        var node = new Node<T>(data);
        if (isEmpty())
            head = tail = node;
        else {
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }
    }

    @Override
    public void remove(T data) {

        if (isEmpty()) {
            System.out.println("List is empty");
        } else if (head.getData()
          .equals(data)) {
            head = head.getNext();
        } else if (tail.getData()
          .equals(data)) {
            head = tail.getPrevious();
        }
        var currentNode = head.getNext();
        while (currentNode != null) {
            if (currentNode.getData()
              .equals(data)) {
                currentNode.getPrevious()
                  .setNext(currentNode.getNext());
                currentNode.getNext()
                  .setPrevious(currentNode.getPrevious());
                break;
            }
            currentNode = currentNode.getNext();
        }
    }

    @Override
    public void traverseFromHead() {
        if (isEmpty()) {
            System.out.println("List empty!");
        }
        var currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode);
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    @Override
    public void traverseFromTail() {
        if (isEmpty()) {
            System.out.println("List empty!");
        }
        var currentNode = tail;
        while (currentNode != null) {
            System.out.print(currentNode);
            currentNode = currentNode.getPrevious();
        }
        System.out.println();
    }

    @Override
    public void traverseRecursivelyFromHead() {
        if (isEmpty()) {
            System.out.println("List empty!");
        }
        traverseHead(head);
        System.out.println();
    }

    @Override
    public void traverseRecursivelyFromTail() {
        if (isEmpty()) {
            System.out.println("List empty!");
        }
        traverseTail(tail);
        System.out.println();
    }

    @Override
    public void reverse() {
        Node<T> temp = null;
        var oldHead = head;
        var currentNode = head;

        while (currentNode != null) {
            temp = currentNode.getPrevious();
            currentNode.setPrevious(currentNode.getNext());
            currentNode.setNext(temp);
            currentNode = currentNode.getPrevious();
        }

        if (temp != null)
            head = temp.getPrevious();
        tail = oldHead;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    void traverseHead(Node<T> node) {
        if (node == null) {
            return;
        }
        System.out.println(node);
        traverseHead(node.getNext());
    }

    void traverseTail(Node<T> node) {
        if (node == null) {
            return;
        }
        System.out.println(node);
        traverseTail(node.getPrevious());
    }
}
