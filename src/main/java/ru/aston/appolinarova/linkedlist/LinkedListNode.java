package ru.aston.appolinarova.linkedlist;


public class LinkedListNode <E extends Comparable<? super E>> {

    private E currentElement;
    private LinkedListNode<E> nextElement;
    private LinkedListNode<E> prevElement;

    public LinkedListNode(E currentElement, LinkedListNode<E> prevElement,  LinkedListNode<E> nextElement) {
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
