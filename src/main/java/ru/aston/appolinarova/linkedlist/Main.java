package ru.aston.appolinarova.linkedlist;

import static jdk.nashorn.internal.objects.NativeArray.sort;

public class Main {

    public static void main(String[] args) {
        LinkedListRealization<Integer> linkedListRealization = new LinkedListRealization();
        linkedListRealization.add(11);
        linkedListRealization.add(7);
        linkedListRealization.add(9);
        linkedListRealization.remove(7);
        System.out.println(linkedListRealization.getElementByIndex(0));
        System.out.println(linkedListRealization.getElementByIndex(1));
        //LinkedListRealization.sort(linkedListRealization, 0, 20);
        System.out.println(linkedListRealization.getElementByIndex(0));

        //System.out.println(linkedListRealization.listSize());
    }
}
