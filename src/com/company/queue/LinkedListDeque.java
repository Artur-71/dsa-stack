package com.company.queue;

public class LinkedListDeque<E> implements Deque<E> {

    private Node<E> front;
    private Node<E> rear;
    private int size;

    public LinkedListDeque() {
    }

    @Override
    public E enqueueFront(E item) {
        Node<E> newNode = new Node<>(item);

        if (front == null) {
            front = newNode;
            rear = front;
            ++size;

            return item;
        }

        newNode.setNext(front);
        front.setPrev(newNode);
        front = newNode;
        ++size;

        return item;
    }

    @Override
    public E enqueueRear(E item) {
        Node<E> newNode = new Node<>(item);

        if (rear == null) {
            rear = newNode;
            front = rear;
            ++size;

            return item;
        }

        newNode.setPrev(rear);
        rear.setNext(newNode);
        rear = newNode;
        ++size;

        return item;
    }

    @Override
    public E dequeueFront() {
        if (front == null) {
            throw new DequeEmptyException("Deque is empty");
        }

        Node<E> nodeToDelete = front;
        if (front == rear) {
            front = null;
            rear = null;
            --size;

            return nodeToDelete.getItem();
        }

        front = front.getNext();
        front.setPrev(null);
        --size;

        return nodeToDelete.getItem();
    }

    @Override
    public E dequeueRear() {
        if (rear == null) {
            throw new DequeEmptyException("Deque is empty");
        }

        Node<E> nodeToDelete = rear;
        if (rear == front) {
            front = null;
            rear = null;
            --size;

            return nodeToDelete.getItem();
        }

        rear = rear.getPrev();
        rear.setNext(null);
        --size;

        return nodeToDelete.getItem();
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<E> {

        private E item;
        private Node<E> next;
        private Node<E> prev;

        public Node(E item) {
            this.item = item;
        }

        public E getItem() {
            return item;
        }

        public void setItem(E item) {
            this.item = item;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }
}
