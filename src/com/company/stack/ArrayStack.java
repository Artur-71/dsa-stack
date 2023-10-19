package com.company.stack;

public class ArrayStack<E> implements Stack<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private final E[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Stack illegal capacity: " + initialCapacity);
        }

        this.elements = (E[]) new Object[initialCapacity];
    }

    @Override
    public E push(E element) {
        if (elements.length == size) {
            throw new StackOverflowException("Stack is full. Max capacity: " + elements.length);
        }

        elements[size] = element;
        ++size;

        return element;
    }

    @Override
    public E pop() {
        E element = top();

        --size;
        elements[size] = null;

        return element;
    }

    @Override
    public E top() {
        if (size == 0) {
            throw new StackEmptyException("Stack is empty.");
        }

        return elements[size - 1];
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }

        size = 0;
    }
}
