package ru.aston.appolinarova.linkedlist;

import java.util.NoSuchElementException;

public class LinkedListRealization<E> implements Linked<E> {


    private int listSize;
    private LinkedListNode<E> firstNode;
    private LinkedListNode<E> lastNode;

    public LinkedListRealization() {
        lastNode = new LinkedListNode<E>(null, firstNode, null);
        firstNode = new LinkedListNode<E>(null, null, lastNode);

    }

    @Override
    public boolean add(E value) {
        final LinkedListNode<E> prev = lastNode;
        prev.setCurrentElement(value);
        lastNode = new LinkedListNode<E>(null, prev, null);
        prev.setNextElement(lastNode);
        listSize++;
        return true;
    }

    public void remove(E element) {
        LinkedListNode<E> current = firstNode;
        while (current.getCurrentElement() != element) {
            current = current.getNextElement();
            if (current == null) {
                throw new NoSuchElementException();
            }
        }
        if (current.getNextElement() != null) {
            current.getNextElement().setPrevElement(current.getPrevElement());
        }
        current.getPrevElement().setNextElement(current.getNextElement());
        listSize--;
    }

    @Override
    public int listSize() {
        return listSize;
    }

    @Override
    public E getElementByIndex(int index) {
        LinkedListNode<E> target = firstNode.getNextElement();
        for (int i = 0; i < index; i++) {
            target = getNextElement(target);
        }
        return target.getCurrentElement();

    }

    private LinkedListNode<E> getNextElement(LinkedListNode<E> current) {
        return current.getNextElement();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinkedListRealization<?> that = (LinkedListRealization<?>) o;

        if (listSize != that.listSize) return false;
        if (firstNode != null ? !firstNode.equals(that.firstNode) : that.firstNode != null)
            return false;
        return lastNode != null ? lastNode.equals(that.lastNode) : that.lastNode == null;
    }

    @Override
    public int hashCode() {
        int result = listSize;
        result = 31 * result + (firstNode != null ? firstNode.hashCode() : 0);
        result = 31 * result + (lastNode != null ? lastNode.hashCode() : 0);
        return result;
    }

    public static void quickSort(int low, int high) {


    }
}
