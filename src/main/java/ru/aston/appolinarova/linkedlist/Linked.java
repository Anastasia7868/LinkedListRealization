package ru.aston.appolinarova.linkedlist;

public interface Linked<E extends Comparable<? super E>> {

    public boolean add(E value);

    public void remove(E element);
    public int listSize();
    public E getElementByIndex(int index);

}
