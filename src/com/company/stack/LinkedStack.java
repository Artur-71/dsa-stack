package com.company.stack;

public class LinkedStack<E> implements Stack<E> {

    private Node<E> head;

    public LinkedStack() {
    }

    @Override
    public E push(E element) {
        head = new Node<>(element, head);

        return head.getData();
    }

    @Override
    public E pop() {
        checkEmpty();

        E data = head.getData();
        head = head.getNext();

        return data;
    }

    @Override
    public E top() {
        checkEmpty();

        return head.getData();
    }

    private void checkEmpty() {
        if (head == null) {
            throw new StackEmptyException("Stack is empty.");
        }
    }

    @Override
    public boolean empty() {
        return head == null;
    }

    @Override
    public void clear() {
        head = null;
    }

    private static class Node<E> {

        private final E data;
        private final Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }
    }
}
