package ru.aston.appolinarova.linkedlist;

import java.util.NoSuchElementException;

public class LinkedListRealization<E extends Comparable<? super E>> implements Linked<E> {

    public static final int DELIMITER = 2;
    private int listSize;
    private LinkedListNode<E> firstNode;
    private LinkedListNode<E> lastNode;


    public LinkedListRealization() {

        lastNode = new LinkedListNode<E>(null, firstNode, null);
        firstNode = new LinkedListNode<E>(null, null, lastNode);
    }

    @Override
    public boolean add(E value) {
        LinkedListNode<E> prev = lastNode;
        prev.setCurrentElement(value);
        lastNode = new LinkedListNode<E>(null, prev, null);
        prev.setNextElement(lastNode);
        listSize++;
        return true;
    }

    @Override
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listSize; i++) {
            sb.append(getElementByIndex(i));
            if (i < (listSize - 1)) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    @Override
    public void quickSort(LinkedListRealization<E> linkedListRealization, int startIndex,
                          int endIndex) {

        if (linkedListRealization.getListSize() == 0) {
            return;
        }
        if (startIndex > endIndex) {
            return;
        }
        int middle = startIndex + (endIndex - startIndex) / DELIMITER;
        int lowBorder = startIndex;
        int highBorder = endIndex;

        while (lowBorder <= highBorder) {
            while (linkedListRealization.getElementByIndex(lowBorder)
                    .compareTo(linkedListRealization.getElementByIndex(middle)) < 0) {
                lowBorder++;
            }
            while (linkedListRealization.getElementByIndex(highBorder)
                    .compareTo(linkedListRealization
                    .getElementByIndex(middle)) > 0) {
                highBorder--;
            }


            if (lowBorder <= highBorder) {
                E tmp = linkedListRealization.getElementByIndex(lowBorder);
                linkedListRealization.getNodeByIndex(lowBorder)
                        .setCurrentElement(linkedListRealization.getElementByIndex(highBorder));
                linkedListRealization.getNodeByIndex(highBorder).setCurrentElement(tmp);
                lowBorder++;
                highBorder--;
            }
        }

        if (startIndex < highBorder) {
            quickSort(linkedListRealization, startIndex, highBorder);
        }
        if (endIndex > lowBorder) {
            quickSort(linkedListRealization, lowBorder, endIndex);
        }

    }


    @Override
    public void clear() {
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

    @Override
    public LinkedListNode getNodeByIndex(int index) {
        LinkedListNode<E> target = firstNode.getNextElement();
        for (int i = 0; i < index; i++) {
            target = getNextElement(target);
        }
        return target;
    }

    private LinkedListNode<E> getNextElement(LinkedListNode<E> current) {
        return current.getNextElement();
    }

    @Override
    public int getListSize() {
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
}
