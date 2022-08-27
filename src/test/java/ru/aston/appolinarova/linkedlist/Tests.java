package ru.aston.appolinarova.linkedlist;

import org.junit.Test;


import java.util.Comparator;
import static org.junit.Assert.assertEquals;

public class Tests {


    @Test
    public void testLinkedList() {
        LinkedListRealization list = new LinkedListRealization();
        list.add("Leo");
        assertEquals(1, list.getListSize());
        list.add("Tom");
        list.add("Anton");
        assertEquals("Leo", list.getFirst());
        assertEquals("Leo Tom Anton", list.toString());
        assertEquals(3, list.getListSize());
        list.remove("Tom");
        assertEquals("Leo Anton", list.toString());
        assertEquals(2, list.getListSize());
        list.quickSort(0, list.getListSize() - 1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        assertEquals("Anton Leo", list.toString());
        list.clear();
        list.add(10);
        list.add(100);
        list.add(1);
        assertEquals("10 100 1", list.toString());
        assertEquals("10", list.getFirst().toString());
        assertEquals("1", list.getLast().toString());
        list.quickSort(0, list.getListSize() - 1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        assertEquals("1 10 100", list.toString());
    }
}
