package ru.aston.appolinarova.linkedlist;

public class LinkedListNode<E> {

    private E currentElement;
    private LinkedListNode<E> nextElement;
    private LinkedListNode<E> prevElement;

    public LinkedListNode(LinkedListNode<E> prevElement, E currentElement, LinkedListNode<E> nextElement) {
        this.currentElement = currentElement;
        this.nextElement = nextElement;
        this.prevElement = prevElement;
    }

    @Override
    public String toString() {
        return "LinkedListNode{ " + currentElement.toString();
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
