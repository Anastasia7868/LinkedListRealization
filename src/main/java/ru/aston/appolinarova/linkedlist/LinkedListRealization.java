package ru.aston.appolinarova.linkedlist;


import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedListRealization<E> implements Linked<E> {

   /* Написать свою реализацию LinkedList (принцип работы связного списка должен сохраниться), обязательные методы:
add - добавляет элемент
delete(Element) - удаляет элемент
sort - сортирует список. Использовать алгоритм quickSort
Остальные методы и принцип реализации на ваше усмотрение.
Опционально: написать тесты на каждый метод*/

    private int listSize;
    private LinkedListNode<E> firstNode;
    private LinkedListNode<E> lastNode;


    public LinkedListRealization() {

    }

    @Override
    public boolean add(E value) {
        final LinkedListNode<E> lastElement = lastNode;
        final LinkedListNode<E> newNode = new LinkedListNode<E>(lastElement, value, null);
        lastNode = newNode;
        if (lastElement == null)
            firstNode = newNode;
        else
            lastElement.setNextElement(newNode);
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


}
