package com.company.binarytree;

public interface BinarySearchTree<E extends Comparable<E>> {

    E insert(E value);

    boolean search(E value);

    E delete(E value);

    void printTree();
}
