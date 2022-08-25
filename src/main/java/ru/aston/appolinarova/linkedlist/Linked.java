package ru.aston.appolinarova.linkedlist;

public interface Linked<E extends Comparable<? super E>> {

    public boolean add(E value);

    public void remove(E element);

    public int getListSize();

    public E getElementByIndex(int index);

    public void quickSort(LinkedListRealization<E> linkedListRealization,
                          int startIndex, int endIndex);

    public void clear();

    public LinkedListNode<E> getNodeByIndex(int index);

}
