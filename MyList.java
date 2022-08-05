package humanResourses;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.UnaryOperator;

public class MyList implements List {
    public Node head;

    public MyList(){
        head = null;
    }

    public void add(String businessTravelsInfo) {
        Node newNode = new Node(businessTravelsInfo);
        Node currentNode = head;

        if (head == null) {
            head = new Node();
            head.next = newNode;
        } else {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    @Override
    public void replaceAll(UnaryOperator operator) {
        List.super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator c) {
        List.super.sort(c);
    }

    @Override
    public Spliterator spliterator() {
        return List.super.spliterator();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    } // сделал

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    public void print(){
        Node currentNode = head;

        if (head != null) {
            System.out.println(head.businessTravelsInfo);
        }

        while (currentNode.next != null) {
            currentNode = currentNode.next;
            System.out.println(currentNode.businessTravelsInfo);
        }
    }

    public class Node {
        String businessTravelsInfo;
        Node next;

        Node(String businessTravelsInfo) {
            this.businessTravelsInfo = businessTravelsInfo;
            this.next = null;
        }

        Node(){
            this.businessTravelsInfo = "Info about business travels";
            this.next = null;
        }
    }
}

