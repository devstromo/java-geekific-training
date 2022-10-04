package com.devstromo;

import java.util.List;

import com.devstromo.tree.BinarySearchTree;
import com.devstromo.tree.Tree;

public record TreeSort<T extends Comparable<T>>(List<T> elements) {

    public void sort() {
        Tree<T> bst = new BinarySearchTree<>();
        elements.forEach(bst::insert);
        bst.traverse();
    }

    public List<T> sortList() {
        Tree<T> bst = new BinarySearchTree<>();
        elements.forEach(bst::insert);
        return bst.getSortedElements();
    }
}
