package ru.aston.appolinarova.linkedlist;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedListRealization<E extends Comparable<? super E>> implements Linked<E> {


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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listSize; i++) {
            sb.append(getElementByIndex(i));
            if (i < (listSize-1)) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public void quickSort(LinkedListRealization<E> linkedListRealization, int startIndex, int endIndex) {

        if (linkedListRealization.listSize() == 0) {
            return;
        }
        if (startIndex > endIndex) {
            return;
        }
        int middle = startIndex + (endIndex - startIndex) / 2;
        int low = startIndex;
        int high = endIndex;

        while (low <= high) {
            while (linkedListRealization.getElementByIndex(low).compareTo(linkedListRealization.getElementByIndex(middle))
                    < 0) {
                low++;
            }
            while (linkedListRealization.getElementByIndex(high).compareTo(linkedListRealization
                    .getElementByIndex(middle)) > 0) {
                high--;
            }

            if (low <= high) {
                E tmp = linkedListRealization.getElementByIndex(low);
                linkedListRealization.getNodeByIndex(low)
                        .setCurrentElement(linkedListRealization.getElementByIndex(high));
                linkedListRealization.getNodeByIndex(high).setCurrentElement(tmp);
                low++;
                high--;
            }
        }

        if (startIndex < high) {
            quickSort(linkedListRealization, startIndex, high);
        }
        if (endIndex > low) {
            quickSort(linkedListRealization, low, endIndex);
        }

    }

    public LinkedListNode getNodeByIndex(int index) {
        LinkedListNode<E> target = firstNode.getNextElement();
        for (int i = 0; i < index; i++) {
            target = getNextElement(target);
        }
        return target;
    }

    public LinkedListNode<E> getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(LinkedListNode<E> firstNode) {
        this.firstNode = firstNode;
    }

    public LinkedListNode<E> getLastNode() {
        return lastNode;
    }

    public void setLastNode(LinkedListNode<E> lastNode) {
        this.lastNode = lastNode;
    }

    public void clear(){
        for (LinkedListNode<E> x = firstNode; x != null; ) {
            LinkedListNode<E> next = x.getNextElement();
            x.setCurrentElement(null);
            x.setNextElement(null);
            x.setPrevElement(null);
            x = next;
        }
        lastNode = new LinkedListNode<E>(null, firstNode, null);
        firstNode = new LinkedListNode<E>(null, null, lastNode);
        listSize = 0;
    }
}
