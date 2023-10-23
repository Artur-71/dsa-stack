package com.company.queue;

public interface Deque<E> {

    E enqueueFront(E item);

    E enqueueRear(E item);

    E dequeueFront();

    E dequeueRear();

    boolean isEmpty();

    int size();
}
