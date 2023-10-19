package com.company.stack;

public interface Stack<E> {

    E push(E element);

    E pop();

    E top();

    boolean empty();

    void clear();
}
