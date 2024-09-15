package DataStructures;

import Exceptions.*;
import ADTs.*;

/**
 * A linked list implementation of a stack.
 * @param <T> the type of elements in this stack, which must be comparable
 */
public class LinkedStack<T extends Comparable<T>> implements StackADT<T> {

    /**
     * The top of the linked list
     */
    private SinglyLinkedNode<T> top;

    /**
     * The number of elements in the linked list
     */
    private int size;

    /**
     * Creates an empty stack
     */
    public LinkedStack() {
        top = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        SinglyLinkedNode<T> current = top;
        while (current != null) {
            sb.append(current.getData()).append(" ");
            current = current.getNext();
        }
        return sb.toString();
    }

    @Override
    public void push(T element) throws StackOverflowException {
        SinglyLinkedNode<T> newNode = new SinglyLinkedNode<>(element);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }
        T result = top.getData();
        top = top.getNext();
        size--;
        return result;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }
        return top.getData();
    }
}