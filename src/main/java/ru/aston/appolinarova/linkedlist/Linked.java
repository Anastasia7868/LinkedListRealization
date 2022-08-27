package ru.aston.appolinarova.linkedlist;

import java.util.Comparator;

public interface Linked<E> {

    public boolean add(E value);

    public void remove(E element);

    public int getListSize();

    public E getElementByIndex(int index);

    public void quickSort(int startIndex, int endIndex, Comparator<? super E> c);

    public void clear();

    public E getFirst();

    public E getLast();

}
