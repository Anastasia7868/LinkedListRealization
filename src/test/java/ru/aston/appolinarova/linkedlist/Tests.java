package ru.aston.appolinarova.linkedlist;

import org.junit.Test;


import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class Tests {

    @Test
    public void testLinkedList() {
        LinkedListRealization list = new LinkedListRealization();
        list.add("Leo");
        assertEquals(1, list.getListSize());
        list.add("Tom");
        list.add("Anton");
        assertEquals("Leo Tom Anton", list.toString());
        assertEquals(3, list.getListSize());
        list.remove("Tom");
        assertEquals("Leo Anton", list.toString());
        assertEquals(2, list.getListSize());
        list.quickSort(list, 0, list.getListSize() - 1);
        assertEquals("Anton Leo", list.toString());
        list.clear();
        list.add(10);
        list.add(100);
        list.add(1);
        assertEquals("10 100 1", list.toString());
        list.quickSort(list, 0, list.getListSize() - 1);
        assertEquals("1 10 100", list.toString());
    }
}
