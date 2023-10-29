package com.company.avltree;

import com.company.binarytree.BinarySearchTree;

public class AvlBinarySearchTree<E extends Comparable<E>> implements BinarySearchTree<E> {

    private Node<E> root;

    public AvlBinarySearchTree() {
    }

    @Override
    public E insert(E value) {
        root = insert(root, value);

        return value;
    }

    private Node<E> insert(Node<E> currNode, E value) {
        if (currNode == null) {
            return new Node<>(value);
        }

        int diff = value.compareTo(currNode.value);
        // If new node is smaller than current element
        if (diff < 0) {
            currNode.left = insert(currNode.left, value);
        }

        // If new node is greater than current element
        if (diff > 0) {
            currNode.right = insert(currNode.right, value);
        }

        return updateBalance(currNode, value);
    }

    private Node<E> updateBalance(Node<E> node, E value) {
        node.updateHeight();
        int balanceFactor = node.getBalanceFactor();

        // Left Left Case
        if (balanceFactor > 1 && value.compareTo(node.left.value) < 0) {
            return rightRotate(node);
        }

        // Left Right Case
        if (balanceFactor > 1 && value.compareTo(node.left.value) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Right Case
        if (balanceFactor < -1 && value.compareTo(node.right.value) > 0) {
            return leftRotate(node);
        }

        // Right Left Case
        if (balanceFactor < -1 && value.compareTo(node.right.value) < 0) {
            node.right = rightRotate(node.right);

            return leftRotate(node);
        }

        return node;
    }

    private Node<E> leftRotate(Node<E> currNode) {
        Node<E> newParent = currNode.right;
        currNode.right = newParent.left;
        newParent.left = currNode;

        currNode.updateHeight();
        newParent.updateHeight();

        return newParent;
    }

    private Node<E> rightRotate(Node<E> currNode) {
        Node<E> newParent = currNode.left;
        currNode.left = newParent.right;
        newParent.right = currNode;

        currNode.updateHeight();
        newParent.updateHeight();

        return newParent;
    }

    @Override
    public E delete(E value) {
        delete(root, value);

        return value;
    }

    private Node<E> delete(Node<E> currNode, E value) {
        if (currNode == null) {
            throw new IllegalArgumentException("Avl Tree doesn't contain node with value: " + value);
        }

        int diff = value.compareTo(currNode.value);

        // If node to delete is smaller than current element
        if (diff < 0) {
            currNode.left = delete(currNode.left, value);
        }
        // If node to delete is greater than current element
        else if (diff > 0) {
            currNode.right = delete(currNode.right, value);
        }
        // If node to delete was found
        else {

            // If node to delete have to children, find the left min node in right subtree
            if (currNode.left != null && currNode.right != null) {
                Node<E> leftMinNode = findLeftMinNode(currNode.right);

                currNode.value = leftMinNode.value;

                // Delete the left min node
                currNode.right = delete(currNode.right, leftMinNode.value);
            }
            // If node have one child or no child
            else {
                Node<E> temp = null;
                if (currNode.left != null) {
                    temp = currNode.left;
                } else if (currNode.right != null) {
                    temp = currNode.right;
                }

                // If node doesn't have child
                if (temp == null) {
                    return null;
                }

                // If node have one child
                currNode = temp;
            }
        }

        return updateBalance(currNode, value);
    }

    private Node<E> findLeftMinNode(Node<E> node) {
        Node<E> curr = node;
        while (curr.left != null) {
            curr = curr.left;
        }

        return curr;
    }

    @Override
    public boolean search(E value) {
        return search(root, value);
    }

    private boolean search(Node<E> node, E value) {
        if (node == null) {
            return false;
        }

        int diff = value.compareTo(node.value);
        if (diff < 0) {
            return search(node.left, value);
        } else if (diff > 0) {
            return search(node.right, value);
        }

        return true;
    }

    @Override
    public void printTree() {
        printInOrder(root);
    }

    private void printInOrder(Node<E> currNode) {
        if (currNode == null) {
            return;
        }

        printInOrder(currNode.left);
        System.out.print(currNode.value + " ");
        printInOrder(currNode.right);
    }

    private static class Node<E extends Comparable<E>> {

        private Node<E> left;
        private Node<E> right;
        private E value;
        private int height = 1;

        public Node(E value) {
            this.value = value;
        }

        public void updateHeight() {
            int leftHeight = left != null ? left.height : 0;
            int rightHeight = right != null ? right.height : 0;

            this.height = Math.max(leftHeight, rightHeight) + 1;
        }

        public int getBalanceFactor() {
            int leftHeight = left != null ? left.height : 0;
            int rightHeight = right != null ? right.height : 0;

            return (leftHeight - rightHeight);
        }
    }
}
