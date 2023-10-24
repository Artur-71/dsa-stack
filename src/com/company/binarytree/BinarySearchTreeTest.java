package com.company.binarytree;

public class BinarySearchTreeTest {

    public static void main(String[] args) {
        LinkedListBinarySearchTree<Integer> tree = new LinkedListBinarySearchTree<>();
        tree.insert(60);
        tree.insert(40);
        tree.insert(10);
        tree.insert(50);
        tree.insert(80);
        tree.insert(55);
        tree.insert(90);

        System.out.println(tree.search(50));
        System.out.println(tree.search(80));
        System.out.println(tree.search(0));

        tree.printTree();
        System.out.println();

        tree.preOrderTraversalRecursive();
        System.out.println();

        tree.inOrderTraversalRecursive();
        System.out.println();

        tree.postOrderTraversalRecursive();
        System.out.println();

        tree.levelOrderTraversalRecursive();
        System.out.println();
    }
}
