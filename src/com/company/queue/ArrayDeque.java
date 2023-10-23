package com.company.queue;


public class ArrayDeque<E> implements Deque<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private final E[] elements;
    private int front = -1;
    private int rear;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayDeque() {
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public ArrayDeque(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Deque illegal capacity: " + initialCapacity);
        }

        this.elements = (E[]) new Object[initialCapacity];
    }

    @Override
    public E enqueueFront(E item) {
        if (isFull()) {
            throw new DequeOverflowException("Deque is full. Max capacity: " + elements.length);
        }

        if (front <= 0) {
            front = elements.length - 1;
        } else {
            --front;
        }

        elements[front] = item;
        ++size;

        return item;
    }

    @Override
    public E enqueueRear(E item) {
        if (isFull()) {
            throw new DequeOverflowException("Deque is full. Max capacity: " + elements.length);
        }

        if (front == -1) {
            front = 0;
        }

        if (rear == elements.length - 1) {
            rear = 0;
        } else {
            ++rear;
        }

        elements[rear] = item;
        ++size;

        return item;
    }

    @Override
    public E dequeueFront() {
        if (isEmpty()) {
            throw new DequeEmptyException("Deque is empty");
        }

        E elementToDelete = elements[front];
        elements[front] = null;
        if (front == rear) {
            front = -1;
            rear = -1;
            --size;

            return elementToDelete;
        }

        if (front == elements.length - 1) {
            front = 0;
        } else {
            ++front;
        }

        --size;

        return elementToDelete;
    }

    @Override
    public E dequeueRear() {
        if (isEmpty()) {
            throw new DequeEmptyException("Deque is empty");
        }

        E elementToDelete = elements[rear];
        elements[rear] = null;
        if (rear == front) {
            rear = -1;
            front = -1;
            --size;

            return elementToDelete;
        }

        if (rear == 0) {
            rear = elements.length - 1;
        } else {
            --rear;
        }

        --size;

        return elementToDelete;
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (front == 0 && rear == elements.length - 1)
                || (front == rear + 1);
    }

    @Override
    public int size() {
        return size;
    }
}
