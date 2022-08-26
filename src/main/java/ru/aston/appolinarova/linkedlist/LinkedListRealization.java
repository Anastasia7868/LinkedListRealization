package ru.aston.appolinarova.linkedlist;

import java.util.NoSuchElementException;

public class LinkedListRealization<E extends Comparable<? super E>> implements Linked<E> {

    public static final int DELIMITER = 2;
    private int listSize;
    private LinkedListNode<E> firstNode;
    private LinkedListNode<E> lastNode;
    //уразобраться с компаратором


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
    public void quickSort(int startIndex, int endIndex) {

        if (getListSize() == 0) {
            return;
        }
        if (startIndex > endIndex) {
            return;
        }
        int middle = startIndex + (endIndex - startIndex) / DELIMITER;
        int lowBorder = startIndex;
        int highBorder = endIndex;

        while (lowBorder <= highBorder) {
            while (getElementByIndex(lowBorder).compareTo(getElementByIndex(middle)) < 0) {
                lowBorder++;
            }
            while (getElementByIndex(highBorder).compareTo(getElementByIndex(middle)) > 0) {
                highBorder--;
            }

            if (lowBorder <= highBorder) {
                E tmp = getElementByIndex(lowBorder);
                getNodeByIndex(lowBorder).setCurrentElement(getElementByIndex(highBorder));
                getNodeByIndex(highBorder).setCurrentElement(tmp);
                lowBorder++;
                highBorder--;
            }
        }

        if (startIndex < highBorder) {
            quickSort(startIndex, highBorder);
        }
        if (endIndex > lowBorder) {
            quickSort(lowBorder, endIndex);
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

    private LinkedListNode<E> getNodeByIndex(int index) {
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

    private static class LinkedListNode<E extends Comparable<? super E>> {

        private E currentElement;
        private LinkedListNode<E> nextElement;
        private LinkedListNode<E> prevElement;

        public LinkedListNode(E currentElement, LinkedListNode<E> prevElement,
                              LinkedListNode<E> nextElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }

        public E getCurrentElement() {
            return currentElement;
        }

        public void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }

        public LinkedListNode<E> getNextElement() {
            return nextElement;
        }

        public void setNextElement(LinkedListNode<E> nextElement) {
            this.nextElement = nextElement;
        }

        public LinkedListNode<E> getPrevElement() {
            return prevElement;
        }

        public void setPrevElement(LinkedListNode<E> prevElement) {
            this.prevElement = prevElement;
        }

    }
}
