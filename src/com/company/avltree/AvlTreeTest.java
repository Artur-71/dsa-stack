package com.company.avltree;

import com.company.binarytree.BinarySearchTree;

public class AvlTreeTest {

    public static void main(String[] args) {
        final BinarySearchTree<Integer> tree = new AvlBinarySearchTree<>();

        tree.insert(40);
        tree.insert(20);
        tree.insert(10);
        tree.insert(25);
        tree.insert(30);
        tree.insert(22);
        tree.insert(50);

        // Delete leaf node
        tree.delete(50);

        // Delete node with one child
        tree.delete(40);

        // Delete node with 2 children
        tree.delete(20);

        // Find existing element
        System.out.println(tree.search(10));

        tree.delete(10);

        // Find non existing element
        System.out.println(tree.search(10));
    }

}
