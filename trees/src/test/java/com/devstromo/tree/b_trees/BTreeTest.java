package com.devstromo.tree.b_trees;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BTreeTest {

    @Test
    public void testBTree() {
        BTree<String, String> bTree = new BTree<>();

        bTree.put("www.cs.princeton.edu", "128.112.136.12");
        bTree.put("www.cs.princeton.edu", "128.112.136.11");
        bTree.put("www.princeton.edu", "128.112.128.15");
        bTree.put("www.yale.edu", "130.132.143.21");
        bTree.put("www.simpsons.com", "209.052.165.60");
        bTree.put("www.apple.com", "17.112.152.32");
        bTree.put("www.amazon.com", "207.171.182.16");
        bTree.put("www.ebay.com", "66.135.192.87");
        bTree.put("www.cnn.com", "64.236.16.20");
        bTree.put("www.google.com", "216.239.41.99");
        bTree.put("www.nytimes.com", "199.239.136.200");
        bTree.put("www.microsoft.com", "207.126.99.140");
        bTree.put("www.dell.com", "143.166.224.230");
        bTree.put("www.slashdot.org", "66.35.250.151");
        bTree.put("www.espn.com", "199.181.135.201");
        bTree.put("www.weather.com", "63.111.66.11");
        bTree.put("www.yahoo.com", "216.109.118.65");
        assertEquals("128.112.136.12", bTree.get("www.cs.princeton.edu"));
    }
}