package ru.aston.appolinarova.linkedlist;

public interface Linked<E extends Comparable<? super E>> {

    public boolean add(E value);

    public void remove(E element);

    public int getListSize();

    public E getElementByIndex(int index);

    public void quickSort(int startIndex, int endIndex);

    public void clear();

}
