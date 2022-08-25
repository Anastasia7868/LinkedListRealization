package ru.aston.appolinarova.linkedlist;

import static jdk.nashorn.internal.objects.NativeArray.sort;

public class Main {

    public static void main(String[] args) {
        LinkedListRealization<String> linkedListRealization = new LinkedListRealization();
        linkedListRealization.add("Nastya");
        linkedListRealization.add("2");
        linkedListRealization.add("3");
        //System.out.println(linkedListRealization.getNodeByIndex(linkedListRealization.listSize()/2).getCurrentElement());
        //linkedListRealization.remove(7);
        //System.out.println(linkedListRealization);
        linkedListRealization.add("4");
        System.out.println(linkedListRealization);
       linkedListRealization.quickSort(linkedListRealization, 0, linkedListRealization.listSize()-1);
        System.out.println(linkedListRealization);
        linkedListRealization.clear();
        System.out.println(linkedListRealization.listSize());
        //LinkedListRealization.sort(linkedListRealization, 0, 20);
        //System.out.println(linkedListRealization.getElementByIndex(0));
       // linkedListRealization.printList();

        //System.out.println(linkedListRealization.listSize());
    }
}
