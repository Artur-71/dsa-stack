package com.company.binarytree;

public class LinkedListBinarySearchTree<E extends Comparable<E>> implements BinarySearchTree<E> {

    private Node<E> root;

    public LinkedListBinarySearchTree() {
    }

    @Override
    public E insert(E value) {
        root = insertValue(root, value);

        return value;
    }

    private Node<E> insertValue(Node<E> currNode, E value) {
        if (currNode == null) {
             return new Node<>(value);
        }

        // If current node value is smaller than insertion element, then traverse the right subtree
        if (currNode.getValue().compareTo(value) < 0) {
            currNode.setRight(insertValue(currNode.getRight(), value));
        }
        // If current node value is greater than insertion element, then traverse the left subtree
        else if (currNode.getValue().compareTo(value) > 0) {
            currNode.setLeft(insertValue(currNode.getLeft(), value));
        }

        return currNode;
    }

    @Override
    public boolean search(E value) {
        return searchValue(root, value);
    }

    private boolean searchValue(Node<E> currNode, E value) {
        // If element was not found
        if (currNode == null) {
            return false;
        }

        // If element was found
        if (currNode.getValue().compareTo(value) == 0) {
            return true;
        }

        // If current node value is smaller than target element, then search in the right subtree
        if (currNode.getValue().compareTo(value) < 0) {
            return searchValue(currNode.getRight(), value);
        }

        // If current node value is greater than target element, then search in the left subtree
        return searchValue(currNode.getLeft(), value);
    }

    @Override
    public E delete(E value) {
        return null;
    }

    @Override
    public void printTree() {
        printInOrder(root);
    }

    public void inOrderTraversalRecursive() {
        printInOrder(root);
    }

    private void printInOrder(Node<E> currNode) {
        if (currNode == null) {
            return;
        }

        printInOrder(currNode.getLeft());
        System.out.print(currNode.getValue() + " ");
        printInOrder(currNode.getRight());
    }

    public void preOrderTraversalRecursive() {
        printPreOrder(root);
    }

    private void printPreOrder(Node<E> currNode) {
        if (currNode == null) {
            return;
        }

        System.out.print(currNode.getValue() + " ");
        printPreOrder(currNode.getLeft());
        printPreOrder(currNode.getRight());
    }

    public void postOrderTraversalRecursive() {
        printPostOrder(root);
    }

    private void printPostOrder(Node<E> currNode) {
        if (currNode == null) {
            return;
        }

        printPostOrder(currNode.getLeft());
        printPostOrder(currNode.getRight());
        System.out.print(currNode.getValue() + " ");
    }

    public void levelOrderTraversalRecursive() {
        printLevelOrder(root);
    }

    private void printLevelOrder(Node<E> currNode) {
        if (currNode == null) {
            return;
        }

        int i = 1;
        int height = height();

        while (i <= height) {
            printLevel(root, i);
            ++i;
        }
    }

    private void printLevel(Node<E> currNode, int level) {
        if (currNode == null) {
            return;
        }

        if (level == 1) {
            System.out.print(currNode.getValue() + " ");
            return;
        }

        printLevel(currNode.getLeft(), level - 1);
        printLevel(currNode.getRight(), level - 1);
    }

    public int height() {
        return calculateHeight(root);
    }

    private int calculateHeight(Node<E> currNode) {
        if (currNode == null) {
            return 0;
        }

        int leftHeight = calculateHeight(currNode.getLeft());
        int rightHeight = calculateHeight(currNode.getRight());

        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        }

        return rightHeight + 1;
    }

    private static class Node<E extends Comparable<E>> {

        private Node<E> left;
        private Node<E> right;
        private E value;

        public Node(E value) {
            this.value = value;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }
    }
}
