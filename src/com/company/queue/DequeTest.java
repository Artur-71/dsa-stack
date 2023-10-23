package com.company.queue;

public class DequeTest {

    public static void main(String[] args) {
        testDeque(new ArrayDeque<>());
        testDeque(new LinkedListDeque<>());
    }

    public static void testDeque(Deque<Integer> deque) {
        System.out.println("Tests for: " + deque.getClass().getSimpleName() + " implementation");

        System.out.printf("Initial. Size: %d. Empty status: %b%n", deque.size(), deque.isEmpty());

        Integer insertedAtFront = deque.enqueueFront(1);

        System.out.printf("After adding element at front. Inserted element: %d. Size: %d. Empty status: %b%n",
                insertedAtFront, deque.size(), deque.isEmpty());

        Integer deletedFromFront = deque.dequeueFront();

        System.out.printf("After deleting element from front. Deleted element: %d. Size: %d. Empty status: %b%n",
                deletedFromFront, deque.size(), deque.isEmpty());

        Integer insertedAtRear = deque.enqueueRear(2);

        System.out.printf("After adding element at rear. Inserted element: %d. Size: %d. Empty status: %b%n",
                insertedAtRear, deque.size(), deque.isEmpty());

        Integer deletedFromRear = deque.dequeueRear();

        System.out.printf("After deleting element from rear. Deleted element: %d. Size: %d. Empty status: %b%n",
                deletedFromRear, deque.size(), deque.isEmpty());

        System.out.println();
    }
}
